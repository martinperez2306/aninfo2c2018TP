var app = angular.module('aninfoApp', ['proyectosModule','empleadosModule','tareasModule']);
var scope = {};

app.factory('asignacionesFunctions',function($http){
	
	return{
	}
})
.controller('asignacionesController', function($scope,proyectosFunctions,empleadosFunctions,tareasFunctions) {
    scope = $scope;
    
    $scope.proyectos = [];
    $scope.tareas = [];
    $scope.empleados = [];
    
    $scope.init = function(){
    	proyectosFunctions.getProyectos(function(response){
    		angular.forEach(response.data, function(proyecto){
    			$scope.proyectos.push(proyecto);
    		})
    	})
    	
    	tareasFunctions.getTareas(function(response){
    		angular.forEach(response.data, function(tarea){
    			$scope.tareas.push(tarea);
    		})
    	})
    	
    	empleadosFunctions.getEmpleados(function(response){
    		angular.forEach(response.data, function(empleado){
    			$scope.empleados.push(empleado);
    		})
    	})
    }
});