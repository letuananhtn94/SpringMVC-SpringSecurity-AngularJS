
app.controller('FreshersController', ['$scope', 'FresherService', function($scope, FresherService) {
	var self = this;
	
	self.fresher = 
		{
			id: null,		
			employeeId: '',
    		fullName: '',
    		sex: '',
    		shortName: '',
    		office: '',
    		cube: ''   	
		}
    
	self.freshers = [];
	
	self.submit = submit;
    self.reset = reset;    
   
    
    fetchAllFresher()
    
    function fetchAllFresher(){
    	return FresherService.fetchAll()
        .then(
	        function(d) {	        	
	        	self.freshers = d;		        	
	        },
	        function(errResponse){
	            console.error('Error while fetching Fresher');
	        }
	    );
        
    }
    
   
    function createFresher(fresher){
    	FresherService.createFresher(fresher)
            .then(
            		fetchAllFresher,
            function(errResponse){
                console.error('Error while creating Fresher');
            }
        );
    }

    function updateFresher(fresher, id){    	
    	FresherService.updateFresher(fresher, id)
        .then(
        		fetchAllFresher,
	        function(errResponse){
	            console.error('Error while updating Fresher');
	        }
        );
    }

    function deleteFresher(id){
    	FresherService.deleteFresher(id)
            .then(
            		fetchAllFresher,
            function(errResponse){
                console.error('Error while deleting Fresher');
            }
        );
    }

    function submit() {
        if(self.fresher.id===null){
            console.log('Saving New Fresher', self.fresher);
            createFresher(self.fresher);
        }else{
            updateFresher(self.fresher, self.fresher.id);
            console.log('Fresher updated with id ', self.fresher.id);
        }
        reset();
    }
    
    function reset(){
    	$scope.fresher = 
		{
    			id: '',		
    			employeeId: '',
        		fullName: '',
        		sex: '',
        		shortName: '',
        		office: '',
        		cube: ''   	
		}
    }
		
}]);

app.filter('sexFormat', function() {
    return function(x) {
        if(x === 'M')
        	return "Male";
        else
        	return "Female";        
    };
});