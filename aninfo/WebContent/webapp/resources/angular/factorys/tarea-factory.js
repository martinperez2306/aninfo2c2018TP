var app = angular.module('aninfoApp', []);

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