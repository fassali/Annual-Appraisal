(function() {

	var app = angular.module('myApp');
	app.controller("LoginController",
			function($scope,$rootScope,$http,EmployersDatasrv,$window,$interval) {
		
		$rootScope.user=null;
		
		$rootScope.loginEmployer=function(){
			EmployersDatasrv.employerLogin($scope.username)
			.then(function(data) {
				$rootScope.user=data;
				if($rootScope.user.manager=="Yes"){
					document.location.href="http://localhost:8080/#!/employers";
				}
			}, function(err) {
				console.log(err.data);
			});
			
		}
		
		
		
		
		
	})

})();