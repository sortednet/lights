'use strict'

describe('Lights controllers', function() {
    beforeEach(function () {
        this.addMatchers({
            toEqualData: function (expected) {
                return angular.equals(this.actual, expected);
            }
        });
    });

    beforeEach(module('lightsApp'));
    beforeEach(module('lightServices'));

    var lights = [
        {"id":0,"name":"Tree fern spot","description":"Spotlight hightlighting the tree fern","on":false},
        {"id":1,"name":"Small bed 1","description":"Low light in the small bed","on":false},
        {"id":2,"name":"Rock spot","description":"Spot light on the rock unter tree fern","on":false}
    ];


    var testSchedules = [
        {id: "0", name: 'sched0', description: "d1", items: [{id: 0, wait: 1, onForSeconds: 3600, light: lights[0]}, {id: 1, wait: 19, onForSeconds: 999, light: lights[0]}]},
        {id: "1", name: 'sched1', description: "d1", items: [{id: 0, wait: 11, onForSeconds: 5000, light: lights[3]}]}
    ];


    describe('ScheduleListCtrl', function () {
        var scope, ctrl, $httpBackend;


        // The injector ignores leading and trailing underscores here (i.e. _$httpBackend_).
        // This allows us to inject a service but then attach it to a variable
        // with the same name as the service in order to avoid a name conflict.
        beforeEach(inject(function (_$httpBackend_, $rootScope, $controller) {
            $httpBackend = _$httpBackend_;
            $httpBackend.expectGET('http://localhost:8080/schedules').respond(testSchedules);

            scope = $rootScope.$new();
            ctrl = $controller('ScheduleListCtrl', {$scope: scope});
        }));

        it('should create "schedules" model with 2 schedule', function() {
            expect(scope.schedules).toEqualData([]);
            $httpBackend.flush();

            expect(scope.schedules).toEqualData(testSchedules);
        });
    });

    describe('ScheduleDetailsCtrl', function () {
        var scope, ctrl, $httpBackend;

        // The injector ignores leading and trailing underscores here (i.e. _$httpBackend_).
        // This allows us to inject a service but then attach it to a variable
        // with the same name as the service in order to avoid a name conflict.
        beforeEach(inject(function (_$httpBackend_, $rootScope, $routeParams, $controller, Schedules, Lights) {
            $httpBackend = _$httpBackend_;
            $httpBackend.expectGET('http://localhost:8080/schedules/0').respond(testSchedules[0]);
            $httpBackend.expectGET('http://localhost:8080/lights').respond(lights);

            $routeParams.scheduleId=0;
            scope = $rootScope.$new();
            ctrl = $controller('ScheduleDetailsCtrl', {$scope: scope, Schedules: Schedules, Lights: Lights});

            $httpBackend.flush(); // Causes the 'get' that is expected when setting up the controller to happen
        }));

        it('should have nothing being edited when initialised', function() {
            expect(scope.editingId == null);
        });

        it('should have schedule 0 in context when initialised', function() {
            expect(scope.schedule).toEqualData(testSchedules[0]);
        });

        it('should edit item when selected', function() {
            scope.editItem(testSchedules[0].items[0]);
            expect(scope.editingId) == testSchedules[0].items[0].id;
        });

        it('should have nothing being edited when canceled', function() {
            scope.reset();
            expect(scope.editingId == null);
        });

        it ("should show item being edited in an edit template", function() {
            scope.editItem(testSchedules[0].items[0]);
            expect(scope.getTemplate(testSchedules[0].items[0]) == "edit")
        });

        it ("should show item not being edited in a display template", function() {
            scope.editItem(testSchedules[0].items[0]);
            expect(scope.getTemplate(testSchedules[0].items[1]) == "display")
        });

        it('should have one more item which is being edited when item added', function() {
            scope.addItem();
            expect(scope.schedule.items.length == 3);
            expect(scope.editingId == -1);
        });

        it('should have one less item when item removed', function() {
            scope.deleteItem(testSchedules[0].items[0]);
            expect(scope.schedule.items.length == 1);
        });

        it('backend PUT should be called when schedule is saved', function() {
            $httpBackend.expectPUT('http://localhost:8080/schedules/0').respond(200);
            expect(scope.schedule).toEqualData(testSchedules[0]);
            scope.editItem(testSchedules[0].items[0]);
            scope.saveItem(testSchedules[0].items[0]);
            expect(scope.editingId == -1);
        });
    });

    describe('ScheduleCreateCtrl', function () {
        var scope, ctrl, $httpBackend;


        // The injector ignores leading and trailing underscores here (i.e. _$httpBackend_).
        // This allows us to inject a service but then attach it to a variable
        // with the same name as the service in order to avoid a name conflict.
        beforeEach(inject(function (_$httpBackend_, $rootScope, $controller) {
            $httpBackend = _$httpBackend_;
            $httpBackend.expectPOST('http://localhost:8080/schedules');

            scope = $rootScope.$new();
            ctrl = $controller('ScheduleCreateCtrl', {$scope: scope});
        }));

    });
});