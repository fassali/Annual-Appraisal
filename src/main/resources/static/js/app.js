var app = angular.module("myApp",['ui.router','ngMaterial',,"chart.js" ]);



// la configuration des des route (les chemin des vues)
app.config(function ($stateProvider, $urlRouterProvider) {
	 // chemin par defaut pour vue accueil
	 $urlRouterProvider.otherwise('/');
	 
		$stateProvider.state('main', {
			
			url : '',
			views : {
				'main' : {
					templateUrl : 'views/content.html',
				},
				'nav@main' : {
					templateUrl : 'views/nav.html',
					controller: 'NavController'
					
				}
			}
		
		})

});
