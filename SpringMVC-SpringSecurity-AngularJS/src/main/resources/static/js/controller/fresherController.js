
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
    	FresherService.fetchAll()
        .then(
	        function(d) {
	        	
	        	self.freshers = d;	
	        	console.log(d);
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
                console.error('Error while creating User');
            }
        );
    }

    function updateFresher(fresher, id){    	
    	FresherService.updateFresher(fresher, id)
        .then(
        		fetchAllFresher,
	        function(errResponse){
	            console.error('Error while updating User');
	        }
        );
    }

    function deleteFresher(id){
    	FresherService.deleteFresher(id)
            .then(
            		fetchAllFresher,
            function(errResponse){
                console.error('Error while deleting User');
            }
        );
    }

    function submit() {
        if(self.fresher.id===null){
            console.log('Saving New User', self.fresher);
            createFresher(self.fresher);
        }else{
            updateFresher(self.fresher, self.fresher.id);
            console.log('User updated with id ', self.fresher.id);
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
	
	$scope.addFresher = function(){
		$scope.freshers.push($scope.fresher);
		$scope.fresher = 
		{
			id: null,
    		full_name: '',
    		sex: '',
    		short_name: '',
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