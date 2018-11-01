
var app = angular.module("myApp",['ui.router','ngMaterial']);



// la configuration des des route (les chemin des vues)
app.config(function ($stateProvider, $urlRouterProvider) {
	 // chemin par defaut pour vue accueil
	 $urlRouterProvider.otherwise('/');
	 
	 $stateProvider.state('skils', {
           url: '/skils',
           templateUrl: 'views/softskil/skils.html',
           controller  :   "skilsCtrl"
       })
       .state('newskils', {
           url: '/skils/save',
           templateUrl: 'views/softskil/newskils.html',
           controller  :   "newSkilsCtrl"
       })
          .state('updateskils', {
           url: '/skils/:id/meaning/:idm',
           templateUrl: 'views/softskil/updateskils.html',
           controller  :   "updateskilsCtrl"
       })      
       .state('newApskils', {
           url: '/apskil/save',
           templateUrl: 'views/softskil/newAppSoftSkil.html',
           controller  :   "newApSoftSkilsCtrl"
       })
;

});

