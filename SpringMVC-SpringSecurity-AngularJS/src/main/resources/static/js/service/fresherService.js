'use strict';


app.factory('FresherService', ['$http', function($http){    
    var factory = {
    	fetchAll: fetchAll,
        createFresher: createFresher,
        updateFresher:updateFresher,
        deleteFresher:deleteFresher,        
    };
    return factory;
    
    
    function fetchAll() {
       
       return $http.get(BASE_URL + "fresher/getAll")
            .then(
            function (response) {            	
            	return response.data;                      
            },
            function(errResponse){                
            	return errResponse;
            }
        );
        
    }

    
    function createFresher(fresher) {
       
        return $http.post(BASE_URL + "fresher/create", fresher)
            .then(
            function (response) {              
                return response.data;
            },
            function(errResponse){
            	return errResponse;
            }
        );
        
    }
   
    function updateFresher(fresher, id) {
       
    	return $http.post(BASE_URL + "fresher/update/" +id, fresher)
            .then(
            function (response) {
            	return response.data;
            },
            function(errResponse){               
            	return errResponse;
            }
        );
        
    }
    
    
    function deleteFresher(id) {
      
    	return $http.get(BASE_URL + "fresher/delete/" +id)
            .then(
            function (response) {
            	return response.data;
            },
            function(errResponse){
            	return errResponse;               
            }
        );        
    }
}]);
