'use strict';

/* Controllers */

var lightControllers = angular.module('lightControllers', []);

lightControllers.controller('ScheduleListCtrl', ['$scope', '$http',
    function($scope, $http) {
        $http.get('schedules/all_schedules.json').success(function(data) {
            $scope.schedules = data;
        });

    }]);

lightControllers.controller('ScheduleDetailsCtrl', ['$scope', '$routeParams', '$http',
    function($scope, $routeParams, $http) {
        $http.get('schedules/all_schedules.json').success(function(data) {
            $scope.scheduleName=$routeParams.scheduleName;
            $scope.schedule = data[$routeParams.scheduleName];
        });
    }]);

