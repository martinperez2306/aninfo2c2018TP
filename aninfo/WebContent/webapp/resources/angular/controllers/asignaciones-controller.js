var app = angular.module('aninfoApp', [,'empleadosModule','tareasModule']);
var scope = {};

app.controller('asignacionesController', function($scope,empleadosFunctions,tareasFunctions) {
    scope = $scope;
    
    $scope.tarea = {};
    $scope.empleados = [];
    
    $scope.init = function(){
    	
//    	tareasFunctions.getTareas(function(response){
//    		angular.forEach(response.data, function(tarea){
//    			$scope.tareas.push(tarea);
//    		})
//    	})
    	
    	empleadosFunctions.getDesarrolladores(function(response){
    		angular.forEach(response.data, function(empleado){
    			$scope.empleados.push(empleado);
    		})
    	})
    }
});