var app = angular.module('empleadosModule', []);

app.factory('empleadosFunctions',function($http){
	
	var getEmpleados = function(callback){
		$http({
			method: 'GET',
			url: '/aninfo/employees'
		}).then(function(response){
			callback(response);
		})
	}
	
	var getDesarrolladores = function(callback){
		$http({
			method: 'GET',
			url: '/aninfo/employees/desarrolladores'
		}).then(function(response){
			callback(response);
		})
	}
	
	return{
		getEmpleados:getEmpleados,
		getDesarrolladores:getDesarrolladores
	}
});