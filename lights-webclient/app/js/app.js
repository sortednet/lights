'use strict'

//var schedules = [ {"name": "notloaded"}];
//
//$http.get('schedules/all_schedules.json').success(function(data) {
//    schedules = data;
//    alert("Got data");
//});

var lightsApp = angular.module('lightsApp', [
    'ngRoute',
    'lightControllers'
]);

lightsApp.config(['$routeProvider',
    function($routeProvider) {
        $routeProvider.
            when('/schedules', {
                templateUrl: 'partials/schedule_list.html',
                controller: 'ScheduleListCtrl'
            }).
            when('/schedules/:scheduleName', {
                templateUrl: 'partials/schedule_details.html',
                controller: 'ScheduleDetailsCtrl'
            }).
            otherwise({
                redirectTo: '/schedules'
            });
    }]);