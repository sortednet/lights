'use strict';

/* Controllers */

var lightControllers = angular.module('lightControllers', []);

lightControllers.controller('ScheduleListCtrl', ['$scope', 'Schedules',
    function($scope, Schedules) {
        $scope.schedules = Schedules.query();
    }
]);

lightControllers.controller('ScheduleDetailsCtrl', ['$scope', '$routeParams', 'Schedules',
    function($scope, $routeParams, Schedules) {

        $scope.editing = {}

        Schedules.get({id: $routeParams.scheduleId}, function(schedule) {
            $scope.schedule = schedule;
        });

        $scope.updateSchedule = function() {
            console.log("Updating schedule "+$scope.schedule.id+" with description "+$scope.schedule.description);
            //console.log("update fn "+$scope.schedule.$update);
            $scope.schedule.$update({ id:$scope.schedule.id}, function() {
                console.log("updated");
            })
            //$scope.schedule.$save();
        }

        $scope.getTemplate = function (light) {
            if (light.id === $scope.editing.id) {
                return 'edit';
            } else {
                return 'display';
            }
        };

        $scope.editLight = function (light) {
            $scope.editing = angular.copy(light);
        };

        $scope.deleteLight = function (light) {
            var idx = $scope.schedule.lights.indexOf(light);
            $scope.schedule.lights.splice(idx, 1);
            $scope.updateSchedule();
            $scope.reset();
        };

        $scope.addLight = function () {
            $scope.schedule.lights.push({id:-1, wait:0, onForSeconds:0})
            $scope.editing = $scope.schedule.lights[ $scope.schedule.lights.length -1];
        };

        $scope.saveLight = function (light) {
            console.log("Saving light");
            $scope.schedule.lights[light] = angular.copy($scope.editing);
            $scope.updateSchedule();
            $scope.reset();
        };

        $scope.reset = function () {
            $scope.editing = {};
        };
    }
]);


