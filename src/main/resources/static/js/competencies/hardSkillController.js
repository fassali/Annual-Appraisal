(function() {

    var app = angular.module("myApp");
    app.controller("hardSkillController", hardSkillController);

    //controller pour client
    function hardSkillController($scope, $window, hardSkillService, $state, $rootScope, $interval) {

        $scope.pageCompetencies = {};
        $scope.currentPage = 0;
        $scope.size = 3;
        $scope.totalePages = 0;
        $scope.pages = [];
        $scope.ratings = [];
        $scope.count=0;
        hardSkillService.getRatings().then(function(data) {
            $scope.ratings = data;
        });

        hardSkillService.getCompetencies(1, $scope.currentPage,
                $scope.size).then(function(data) {
                $scope.pageCompetencies = data.content;
                $scope.totalePages = data.totalPages;
                $scope.pages = new Array(data.totalPages);
            });


        $scope.ratingChanged = function(obj, rating) {
            obj.rating = rating;
        }

        $scope.commentChanged = function(obj, comment) {
            obj.comment = comment;
        }

        // update competencies
        $scope.updateCompetencies = function() {
        	hardSkillService.updateCompetencies($scope.pageCompetencies).then(function(data) {
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

        // initialize
        $scope.annuler = function() {
        	hardSkillService.getCompetencies(1, $scope.currentPage,
                    $scope.size).then(function(data) {
                    $scope.pageCompetencies = data.content;
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