var app = angular.module('aninfoApp', ['empleadosModule']);
var scope = {};

app.controller('mainController', function($scope,empleadosFunctions) {
    scope = $scope;
    
    $scope.empleados = [];
    
    $scope.empleadoSelected = null;
    
    $scope.init = function(){
    	empleadosFunctions.getEmpleados(function(response){
    		angular.forEach(response.data, function(proyecto){
    			$scope.empleados.push(proyecto);
    		})
    	})
    }      
    
});