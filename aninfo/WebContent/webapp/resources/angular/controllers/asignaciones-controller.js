var app = angular.module('aninfoApp', [,'empleadosModule','tareasModule']);
var scope = {};

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
			data:proyecto
		}).then(function(response){
			callback(response);
		})
	}
	
	var deleteAsignacion = function(asignacion,callback){
		$http({
			method:'DELETE',
			url: '/aninfo/asignacion/' + asignacion.id
		}).then(function(response){
			callback(response);
		})
	}
	
	return{
		getAsignaciones:getAsignaciones,
		addAsignacion:addAsignacion,
		deleteAsignacion:deleteAsignacion
	}
})
.controller('asignacionesController', function($scope,$location,empleadosFunctions,tareasFunctions) {
    scope = $scope;
    
    $scope.codigoTarea = $location.absUrl().split("/")[7];
    
    $scope.tarea = {};
    $scope.empleados = [];
    
    $scope.init = function(){
    	
    	tareasFunctions.getTarea($scope.codigoTarea,function(response){
    		scope.tarea = response.data;
    	})
    	
    	empleadosFunctions.getDesarrolladores(function(response){
    		angular.forEach(response.data, function(empleado){
    			$scope.empleados.push(empleado);
    		})
    	})
    }
});