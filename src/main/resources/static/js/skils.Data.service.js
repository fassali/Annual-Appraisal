(function () {


var app = angular.module("myApp");

app.service("skilsDataService",function ($http,$location) {
	var localhost = "http://localhost:8080/";
	
	// list skils
    this.gestAllSkils = function(){

        var promise1    =   $http({
            method : "GET",
            url : "http://localhost:8080/skils"
        });


        var promise2 = promise1.then(function mySuccess(response) {

            return response.data;

        }, function myError(response) {

        });

        return promise2;
        };
        
        // recuperer un skils
        this.getSkils = function (id) {
            var promise1    =   $http({
                method : "GET",
                url: "http://localhost:8080/skils/"+id
            });

            
            var promise2 = promise1.then(function mySuccess(response) {

                return response.data;

            }, function myError(response) {
                  
            });
          
            return promise2;
        };
        // update skils
        this.updateSkils = function(skils){


        	return  $http.put("http://localhost:8080/skils/"+skils.idSkils,skils)
            .then(function mySuccess(response) {
            	
            	return response.data;
            }, function myError(response) {
               

            });
        };
        //
        // ajouter un skils
        this.newSkils = function(skils){


        	return $http.post("http://localhost:8080/skils/save",skils)
                .then(function mySuccess(response) {
                	return response.data;
                }, function myError(response) {
                   

                });
        };
        // recuperer un meanig
        this.getMeaning = function (id,idm) {
            var promise1    =   $http({
                method : "GET",
                url: "http://localhost:8080/skils/"+id+"/meaning/"+idm
            });

            
            var promise2 = promise1.then(function mySuccess(response) {

                return response.data;

            }, function myError(response) {
                  
            });
          
            return promise2;
        };
        //
        
})
})();