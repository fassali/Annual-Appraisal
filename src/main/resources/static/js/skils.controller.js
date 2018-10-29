(function () {


var app = angular.module("myApp");
app.controller("skilsCtrl",skilsCtrl);


function skilsCtrl($scope,skilsDataService,$http,$location,$window) {
	$scope.skils = {};
	
	skilsDataService.gestAllSkils().then(function(data) {
		$scope.skils = data;
		console.log($scope.skils)

	});
	$scope.onclickee = function(id , idM) {
		console.log("id "+id+" idm "+idM);
	}
}

})();