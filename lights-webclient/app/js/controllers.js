'use strict';

/* Controllers */

var lightsApp = angular.module('lightsApp', []);

lightsApp.controller('ScheduleListCtrl', ['$scope', '$http',
    function($scope, $http) {

        $http.get('schedules/all_schedules.json').success(function(data) {
            $scope.schedules = data;
        });

    }]);

