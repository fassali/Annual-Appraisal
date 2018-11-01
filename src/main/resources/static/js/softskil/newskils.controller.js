(function () {


var app = angular.module("myApp");
app.controller("newSkilsCtrl",newSkilsCtrl);


function newSkilsCtrl($scope,skilsDataService,$http,$location,$window) {
	$scope.skils = {};
	$scope.newskils = {};
	$scope.meaning ={};
	$scope.listmeaning =[];
	$scope.allskils = {};
	$scope.levels = [];
	$scope.save = function() {
		$scope.newskils.levels = [];
		console.log($scope.newskils)
		
		skilsDataService.newSkils($scope.newskils).then(function(data) {
			$scope.newskils = {};
			console.log(data)
			$scope.allskils.push(data);
				});
	}

	$scope.ajouter = function() {
		//$scope.skils.levels = [];
		$scope.skils.levels.push($scope.meaning)
		//$scope.skils.meaningSkils = $scope.listmeaning
		console.log($scope.skils);
		skilsDataService.newSkils($scope.skils).then(function(data) {
			skilsDataService.getSkils($scope.skils.idSoftSkill).then(function(data){
				$scope.skils.levels = [];
				$scope.skils.levels = data.levels;
				$scope.meaning ={};
			});
				});
	}
	$scope.ajouterLevel = function() {
		//$scope.skils.levels = [];
		var idx = false;
//		$scope.skils.levels.forEach(function(element) {
//			 if(element.degree == $scope.meaning.degree)
//				 {
//				 idx = true;
//				 }
//			});
	//	if(!idx){
			
		
		$scope.skils.levels.push($scope.meaning)
		//$scope.skils.meaningSkils = $scope.listmeaning
		skilsDataService.newLevel($scope.skils).then(function(data) {
			skilsDataService.getSkils($scope.skils.idSoftSkill).then(function(data){
				$scope.skils.levels = [];
				$scope.skils.levels = data.levels;
				$scope.meaning ={};
			});
				});
		//}
	}
		
		skilsDataService.gestAllSkils().then(function(data) {
			$scope.allskils = data;
			$scope.skils = $scope.allskils[0]
		});
	
}

})();