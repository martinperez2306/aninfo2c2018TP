var app = angular.module('aninfoApp', [,'empleadosModule','tareasModule']);
var scope = {};

app.controller('asignacionesController', function($scope,$location,empleadosFunctions,tareasFunctions) {
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