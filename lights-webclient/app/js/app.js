'use strict'

var lightsApp = angular.module('lightsApp', [
    'ngRoute',
    'lightControllers',
    'lightServices'
]);

lightsApp.config(['$routeProvider',
    function($routeProvider) {
        $routeProvider.
            when('/schedules', {
                templateUrl: 'partials/schedule_list.html',
                controller: 'ScheduleListCtrl'
            }).
            when('/schedules/:scheduleId', {
                templateUrl: 'partials/schedule_details.html',
                controller: 'ScheduleDetailsCtrl'
            }).
            otherwise({
                redirectTo: '/schedules'
            });
    }]);