	

(function() {

	var app = angular.module('myApp');
	app.controller("AdminController",
			function($scope,$rootScope,$http,EmployersDatasrv,$interval) {
		
		
		$scope.page = [];
		$scope.pageCourante = 0;
		$scope.size = 6;
		$scope.mode=0;
		$scope.employers=[];
		$scope.count=0;
		
		
		

EmployersDatasrv.findAllEmployers($scope.pageCourante,$scope.size)	
		.then(function(data){
			 $scope.employers=data.content;
			 console.log($scope.employers);
			 for(var j = 0; j < $scope.employers.length; j++){
			 var appday=$scope.employers[j].dateEntry;
			 var d = new Date(appday);
				$scope.day=d.getDate();
				$scope.month=d.getMonth()+1;
				$scope.year=d.getFullYear();
				console.log($scope.day+"/"+$scope.month);
		 }
	         $scope.pages = new Array(data.totalPages);
           
        });


//changer les pages
$scope.gotopage = function (p) {
	$scope.pageCourante = p;
 $scope.init(); 	   
} 

//fonction utilisée changer les pages
$scope.init=function(){
	EmployersDatasrv.findAllEmployers($scope.pageCourante,$scope.size)	
	 .then(function(data){
           $scope.employers=data.content;
           $scope.pages = new Array(data.totalPages);
       });
}











	})

})();