'use strict';

/* Controllers */

var lightControllers = angular.module('lightControllers', []);

lightControllers.controller('ScheduleListCtrl', ['$scope', 'Schedules',
    function($scope, Schedules) {
        $scope.schedules = Schedules.query();
    }
]);

lightControllers.controller('ScheduleDetailsCtrl', ['$scope', '$routeParams', 'Schedules', 'Lights',
    function($scope, $routeParams, Schedules, Lights) {

        $scope.editingId = null;

        Schedules.get({id: $routeParams.scheduleId}, function(schedule) {
            $scope.schedule = schedule;
        });

        $scope.allLights = Lights.query();

        $scope.updateSchedule = function() {
            console.log("Updating schedule "+$scope.schedule.id+" with description "+$scope.schedule.description);
            $scope.schedule.$update({ id:$scope.schedule.id}, function() {
                console.log("updated");
                Schedules.get({id: $routeParams.scheduleId}, function(schedule) { $scope.schedule = schedule; });
            });
        }

        $scope.getTemplate = function (item) {
            if (item.id === $scope.editingId) {
                return 'edit';
            } else {
                return 'display';
            }
        };

        $scope.editItem = function (item) {
            $scope.editingId = item.id;
        };

        $scope.deleteItem = function (item) {
            var idx = $scope.schedule.items.indexOf(item);
            $scope.schedule.items.splice(idx, 1);
            $scope.updateSchedule();
            $scope.reset();
        };

        $scope.addItem = function () {
            $scope.schedule.items.push({id:-1, wait:0, onForSeconds:0, scheduleId:$scope.schedule.id})
            $scope.editingId = $scope.schedule.items[ $scope.schedule.items.length -1].id;
        };

        $scope.saveItem = function (item) {
            console.log("Saving schedule item id="+item.id+" with selectedLight id"+$scope.selectedLightId);

            $scope.updateSchedule();
            $scope.reset();
        };

        $scope.reset = function () {
            $scope.editingId = null;
        };
    }
]);


lightControllers.controller('LightsCtrl', ['$scope', '$routeParams', 'Lights',
    function($scope, $routeParams, Lights) {

        $scope.lights = Lights.query();

        $scope.toggleSwitch = function(index) {
            console.log("Toggle light "+!$scope.lights[index]+" to "+!$scope.lights[index].on);

            $scope.lights[index].on = !$scope.lights[index].on;
            $scope.lights[index].$update({ id:$scope.lights[index].id}, function() {
                console.log("updated light");
            });
        };

    }
]);


