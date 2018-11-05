
var app = angular.module("myApp",['ui.router','ngMaterial']);



// la configuration des des route (les chemin des vues)
app.config(function ($stateProvider, $urlRouterProvider) {
	 // chemin par defaut pour vue accueil
	 $urlRouterProvider.otherwise('/');
	 

		$stateProvider.state('lastObj',
			{
			url : '/obj',
            templateUrl : 'views/objectives/lastObjectives.html',
            controller: 'objController'
		})
            .state('session',
                {
                    url : '/session',
                    templateUrl : 'views/startSession.html',
                    controller: 'annualSessController'
                })

            .state('skils', {
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
           url: '/skils/:id',
           templateUrl: 'views/softskil/updateskils.html',
           controller  :   "newSkilsCtrl"
       })      
       .state('newApskils', {
           url: '/apskil/save',
           templateUrl: 'views/softskil/newAppSoftSkil.html',
           controller  :   "newApSoftSkilsCtrl"
       })
;

});

