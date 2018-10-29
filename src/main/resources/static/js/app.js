var app = angular.module("myApp",["ui.router"]);



//la configuration des des route (les chemin des vues)
app.config(function ($stateProvider, $urlRouterProvider) {

    //chemin par defaut pour vue accueil
    $urlRouterProvider.otherwise('/');

    $stateProvider

    //chemin pour accéder a la vue pour afficher la liste des contacts
        .state('skils', {
            url: '/skils',
            templateUrl: 'views/skils.html',
            controller  :   "skilsCtrl"
        })
        .state('newskils', {
            url: '/skils/save',
            templateUrl: 'views/newskils.html',
            controller  :   "newSkilsCtrl"
        })
           .state('updateskils', {
            url: '/skils/:id/meaning/:idm',
            templateUrl: 'views/updateskils.html',
            controller  :   "updateskilsCtrl"
        })
;
});