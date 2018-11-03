(function() {

	var app = angular.module('myApp');
	app.service("EmployersDatasrv", function($http) {
		
		//get un employeur par son login
		this.employerLogin=function(username){
	        var promise1=$http({
	            method: 'GET',
	            url: "http://localhost:8080/employerLogin/"+username
	            });
	        var promise2=promise1.then(function(response){
	        	return response.data;
	        },function(err){
	            console.log(err);

	        });
	     return promise2;
	    }
			
			


	})

})();