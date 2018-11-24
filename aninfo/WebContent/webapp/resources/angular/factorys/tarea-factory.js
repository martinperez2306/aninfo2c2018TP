var app = angular.module('tareasModule', []);

app.factory('tareasFunctions',function($http){
	
	var getTareas = function(callback){
		$http({
			method: 'GET',
			url: '/aninfo/tasks'
		}).then(function(response){
			callback(response);
		})
	}
	
	return{
		getTareas:getTareas
	}
});