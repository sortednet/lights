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
            when('/addschedule', {
                templateUrl: 'partials/schedule_create.html',
                controller: 'ScheduleCreateCtrl'
            }).
            when('/schedules/:scheduleId', {
                templateUrl: 'partials/schedule_details.html',
                controller: 'ScheduleDetailsCtrl'
            }).
            when('/lights', {
                templateUrl: 'partials/lights.html',
                controller: 'LightsCtrl'
            }).
            otherwise({
                redirectTo: '/lights'
            });
    }]);