var app = angular.module('proyectosModule', []);

app.factory('proyectosFunctions',function($http){
	
	var getProyectos = function(callback){
		$http({
			method: 'GET',
			url: '/aninfo/projects'
		}).then(function(response){
			callback(response);
		})
	}
	
	var addProyecto = function(proyecto,callback){
		$http({
			method:'POST',
			url: '/aninfo/projects',
			data:proyecto
		}).then(function(response){
			callback(response);
		})
	}
	
	var deleteProyecto = function(proyecto,callback){
		$http({
			method:'DELETE',
			url: '/aninfo/projects/' + proyecto.codigo
		}).then(function(response){
			callback(response);
		})
	}
	
	var getProyecto = function(codigoProyecto,callback){
		$http({
			method: 'GET',
			url: '/aninfo/projects/'+codigoProyecto
		}).then(function(response){
			callback(response);
		})
	}
	
	return{
		getProyectos:getProyectos,
		addProyecto:addProyecto,
		deleteProyecto:deleteProyecto,
		getProyecto:getProyecto
	}
});