'use strict';

/* Controllers */

var lightControllers = angular.module('lightControllers', []);

lightControllers.controller('ScheduleListCtrl', ['$scope', '$http',
    function($scope, $http) {
        $http.get('http://localhost:8080/schedules').success(function(data) {
            console.log("Loaded ",data);
            $scope.schedules = data;
        }).error(function(response) {
            console.error("Could not load data ", response);

        });

    }]);

lightControllers.controller('ScheduleDetailsCtrl', ['$scope', '$routeParams', '$http',
    function($scope, $routeParams, $http) {

        var url = "http://localhost:8080/schedule?id="+$routeParams.scheduleId;
        $http.get(url).success(function(data) {
            $scope.schedule = data;
        });

        //$http.get('schedules/all_schedules.json').success(function(data) {
        //    var id = $routeParams.scheduleId;
        //    var filtered=data.filter(function(s) { return s.id == id});
        //    $scope.schedule = filtered[0];
        //});
    }]);

