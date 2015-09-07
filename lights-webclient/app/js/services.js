var lightServices = angular.module('lightServices', ['ngResource']);

//lightServices.factory('Schedules', ['$resource',
//    function($resource){
//        return $resource('http://localhost:8080/schedules/:id');
//    }]);



lightServices.factory('Schedules', ['$resource',
    function($resource){
        return $resource('http://localhost:8080/schedules/:id', null, {
            'update': { method:'PUT'}
        });
    }]);