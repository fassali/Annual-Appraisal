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
                    controller: 'annualSessController.js'
                })

});
