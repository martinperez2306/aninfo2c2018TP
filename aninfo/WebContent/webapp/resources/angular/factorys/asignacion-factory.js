var app = angular.module('asignacionesModule',[]);

app.factory('asignacionesFunctions',function($http){
	
	var getAsignaciones = function(callback){
		$http({
			method: 'GET',
			url: '/aninfo/asignaciones'
		}).then(function(response){
			callback(response);
		})
	}
	
	var addAsignacion = function(asignacion,callback){
		$http({
			method:'POST',
			url: '/aninfo/asignaciones',
			data:asignacion
		}).then(function(response){
			callback(response);
		})
	}
	
	var deleteAsignacion = function(asignacion,callback){
		$http({
			method:'DELETE',
			url: '/aninfo/asignaciones/' + asignacion.id
		}).then(function(response){
			callback(response);
		})
	}
	
	var getAsignacionesEmpleado = function(dniEmpleado,callback){
		$http({
			method:'GET',
			url: '/aninfo/asignaciones/empleados/' + dniEmpleado
		}).then(function(response){
			callback(response);
		})
	}
	
	return{
		getAsignaciones:getAsignaciones,
		addAsignacion:addAsignacion,
		deleteAsignacion:deleteAsignacion,
		getAsignacionesEmpleado:getAsignacionesEmpleado
	}
});