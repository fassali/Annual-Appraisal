(function () {


var app = angular.module("myApp");
app.controller("updateskilsCtrl",updateskilsCtrl);


function updateskilsCtrl($scope,skilsDataService,$http,$state,$stateParams) {
	$scope.skils = {};
	

	skilsDataService.getMeaning($stateParams.id,$stateParams.idm).then(
			function(data) {
				$scope.skils = data;
//				console.log($scope.skils);
			})
	$scope.update = function() {
		skilsDataService.updateSkils($scope.skils).then(
				function(data) {
					$scope.skils = data;
					$state.go("skils", {}, {
						reload : true
					});
//					console.log($scope.skils);
				})
	}
}

})();