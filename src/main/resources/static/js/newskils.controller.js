(function () {


var app = angular.module("myApp");
app.controller("newSkilsCtrl",newSkilsCtrl);


function newSkilsCtrl($scope,skilsDataService,$http,$location,$window) {
	$scope.skils = {};
	$scope.newskils = {};
	$scope.meaning ={};
	$scope.listmeaning =[];
	$scope.allskils = {};
	
	$scope.save = function() {
		$scope.newskils.meaningSkils = [];
		console.log($scope.newskils)
		
		skilsDataService.newSkils($scope.newskils).then(function(data) {
			$scope.newskils = {};
			console.log(data)
			$scope.allskils.push(data);
				});
	}

	$scope.ajouter = function() {
		$scope.skils.meaningSkils = [];
		$scope.skils.meaningSkils.push($scope.meaning)
		//$scope.skils.meaningSkils = $scope.listmeaning
		console.log($scope.skils);
		skilsDataService.newSkils($scope.skils).then(function(data) {
			skilsDataService.getSkils($scope.skils.idSkils).then(function(data){
				$scope.skils.meaningSkils = [];
				$scope.skils.meaningSkils = data.meaningSkils;
				//console.log(data)
			});
				});
	}

		
		skilsDataService.gestAllSkils().then(function(data) {
			$scope.allskils = data;
			$scope.skils = $scope.allskils[0]
		});
	
}

})();