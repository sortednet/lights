var lightServices = angular.module('lightServices', ['ngResource']);


lightServices.factory('Schedules', ['$resource',
    function($resource){
        return $resource('/schedules/:id', null, {
            'update': { method:'PUT'}
        });
    }]);

lightServices.factory('Lights', ['$resource',
    function($resource){
        return $resource('/lights/:id', null, {
            'update': { method:'PUT'}
        });
    }]);