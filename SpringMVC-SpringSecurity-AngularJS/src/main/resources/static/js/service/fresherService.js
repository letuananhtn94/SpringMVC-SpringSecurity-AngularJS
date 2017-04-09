'use strict';


app.factory('FresherService', ['$http', '$q', function($http, $q){    
    var factory = {
    	fetchAll: fetchAll,
        createFresher: createFresher,
        updateFresher:updateFresher,
        deleteFresher:deleteFresher,        
    };
    return factory;
    
    
    function fetchAll() {
        var deferred = $q.defer();

        $http.get(BASE_URL + "fresher/getAll")
            .then(
            function (response) {
                deferred.resolve(response.data);                
            },
            function(errResponse){                
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    //Service all api create user 
    function createFresher(fresher) {
        var deferred = $q.defer();

        $http.post(BASE_URL + "fresher/create", fresher)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
               
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
    //Service call api update user
    function updateFresher(fresher, id) {
        var deferred = $q.defer();
        $http.post(BASE_URL + "fresher/update/" +id, fresher)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){               
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
    
    
    function deleteFresher(id) {
        var deferred = $q.defer();

        $http.get(BASE_URL + "fresher/delete/" +id)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
}]);
