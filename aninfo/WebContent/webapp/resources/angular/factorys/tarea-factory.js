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
	
	var addTarea = function(tarea,callback){
		$http({
			method: 'POST',
			url: '/aninfo/tasks',
			data:tarea
		}).then(function(response){
			callback(response);
		})
	}
	
	var deleteTarea = function(tarea,callback){
		$http({
			method: 'DELETE',
			url: '/aninfo/tasks/'+tarea.codigo
		}).then(function(response){
			callback(response);
		})
	}
	
	var getTarea = function(codigoTarea,callback){
		$http({
			method: 'GET',
			url: '/aninfo/tasks/'+codigoTarea
		}).then(function(response){
			callback(response);
		})
	}
	
	return{
		getTareas:getTareas,
		addTarea:addTarea,
		deleteTarea:deleteTarea,
		getTarea:getTarea
	}
});