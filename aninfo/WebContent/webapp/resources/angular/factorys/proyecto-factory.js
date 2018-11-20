var app = angular.module('aninfoApp', []);

app.factory('proyectosFunctions',function($http){
	
	var getProyectos = function(callback){
		$http({
			method: 'GET',
			url: '/aninfo/projects'
		}).then(function(response){
			callback(response);
		})
	}
	
	return{
		getProyectos:getProyectos
	}
});