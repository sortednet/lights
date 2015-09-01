'use strict';

/* Controllers */

var lightsApp = angular.module('lightsApp', []);

lightsApp.controller('ScheduleListCtrl', function($scope) {
    $scope.schedules = [

        {
            'name': 'summer',
            'description': 'Schedule for a nice summers night',
            'lights': [
                {'id': '0', 'wait': '60', 'onFor': '180'},
                {'id': '1', 'wait': '10', 'onFor': '120'},
                {'id': '2', 'wait': '30', 'onFor': '210'},
                {'id': '3', 'wait': '00', 'onFor': '180'}
            ]
        },
        {
            'name': 'winter',
            'description': 'Schedule for a winter night',
            'lights': [
                {'id': '0', 'wait': '00', 'onFor': '240'},
                {'id': '1', 'wait': '10', 'onFor': '240'},
                {'id': '2', 'wait': '30', 'onFor': '210'},
                {'id': '3', 'wait': '00', 'onFor': '180'}
            ]
        }
    ];
});
//lightControllers.controller('ScheduleListCtrl', ['$scope', '$http',
//    function($scope, $http) {
//
//
//
//        $http.get('schedules/all_schedules.json').success(function(data) {
//            $scope.schedules = data;
//            alert("loaded schedules")
//        });
//
//    }]);