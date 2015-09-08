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

    var testSchedules = [
        {id: "0", name: 'sched0', description: "d1", lights: [{id: 0, wait: 1, onForSeconds: 3600}, {id: 1, wait: 19, onForSeconds: 999}]},
        {id: "1", name: 'sched1', description: "d1", lights: [{id: 0, wait: 11, onForSeconds: 5000}]}
    ];

    describe('ScheduleListCtrl', function () {
        var scope, ctrl, $httpBackend;



        // The injector ignores leading and trailing underscores here (i.e. _$httpBackend_).
        // This allows us to inject a service but then attach it to a variable
        // with the same name as the service in order to avoid a name conflict.
        beforeEach(inject(function (_$httpBackend_, $rootScope, $controller) {
            $httpBackend = _$httpBackend_;
            $httpBackend.expectGET('http://localhost:8080/schedules').
                respond(testSchedules);

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
        beforeEach(inject(function (_$httpBackend_, $rootScope, $routeParams, $controller, Schedules) {
            $httpBackend = _$httpBackend_;
            $httpBackend.expectGET('http://localhost:8080/schedules/0').respond(testSchedules[0]);

            $routeParams.scheduleId=0;
            scope = $rootScope.$new();
            ctrl = $controller('ScheduleDetailsCtrl', {$scope: scope, Schedules: Schedules});

            $httpBackend.flush(); // Causes the 'get' that is expected when setting up the controller to happen
        }));

        it('should have nothing being edited when initialised', function() {
            expect(scope.editing).toEqualData({});
        });

        it('should have schedule 0 in context when initialised', function() {
            expect(scope.schedule).toEqualData(testSchedules[0]);
        });

        it('should edit light when selected', function() {
            scope.editLight(testSchedules[0].lights[0]);
            expect(scope.editing).toEqualData(testSchedules[0].lights[0]);
        });

        it('should have nothing being edited when canceled', function() {
            scope.reset();
            expect(scope.editing).toEqualData({});
        });

        it ("should show light being edited in an edit template", function() {
            scope.editLight(testSchedules[0].lights[0]);
            expect(scope.getTemplate(testSchedules[0].lights[0]) == "edit")
        });

        it ("should show light not being edited in a display template", function() {
            scope.editLight(testSchedules[0].lights[0]);
            expect(scope.getTemplate(testSchedules[0].lights[1]) == "display")
        });

        it('should have one more light which is being edited when light added', function() {
            scope.addLight();
            expect(scope.schedule.lights.length == 3);
            expect(scope.editing).toEqualData({id: -1, wait: 0, onForSeconds: 0});
        });

        it('should have one less light when light removed', function() {
            scope.deleteLight(testSchedules[0].lights[0]);
            expect(scope.schedule.lights.length == 1);
        });

        it('backend PUT should be called when schedule is saved', function() {
            $httpBackend.expectPUT('http://localhost:8080/schedules/0').respond(200);
            expect(scope.schedule).toEqualData(testSchedules[0]);
            scope.editLight(testSchedules[0].lights[0]);
            scope.saveLight(testSchedules[0].lights[0]);
            expect(scope.editing).toEqualData({});
        });
    });
});