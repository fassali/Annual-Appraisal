(function() {

    var app = angular.module("myApp");
    app.controller("objController", objController);

    //controller pour client
    function objController($scope, $window, objService, $state, $rootScope, $interval) {

        $scope.pageLastObj = {};
        $scope.count=0;



        //faire appel au service objectif pour recuperer les objectifs

        objService.startNewSess().then(function(data) {
            $rootScope.msgSession = "the " + data.label
                + " session is started"
            stop = $interval(function() {
                $scope.count = $scope.count + 1;
                if ($scope.count == 5)
                    $scope.stopmsg();
            }, 500);

        });



        // Modifier les objectifs d'un employé
        $scope.updateLastObj = function() {
            objService.updateObjectives($scope.pageLastObj).then(function(data) {
                    $scope.ajoutMessage = "update avec succés!";
                    stop = $interval(function() {
                        $scope.count = $scope.count + 1;
                        if ($scope.count == 5)
                            $scope.stopmsg();
                    }, 500);
                }, function(err) {
                    alert(err.message);
                }
            );
        }

        // Annuler les MAJ des objectifs
        $scope.annuler = function() {
            /*$scope.listObj = [];
            $scope.listObj = $scope.pageLastObj;*/
            objService.getLastObjs("2019", 1, $scope.currentPage,
                $scope.size).then(function(data) {
                $scope.pageLastObj = data.content;
                $scope.totalePages = data.totalPages;
                $scope.pages = new Array(data.totalPages);
            });
            $window.location.reload();
        }

        $scope.stopmsg = function() {
            if (angular.isDefined(stop)) {
                $interval.cancel(stop);
                stop = undefined;
                $scope.ajoutMessage = null;
            }
        };

    }
})();