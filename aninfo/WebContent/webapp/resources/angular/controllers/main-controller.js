var app = angular.module('aninfoApp', []);
var scope = {};

app.factory('empleadosFunctions',function($http){
	
	var getEmpleados = function(callback){
		$http({
			method: 'GET',
			url: '/aninfo/employees'
		}).then(function(response){
			callback(response);
		})
	}
	
	return{
		getEmpleados:getEmpleados
	}
})
.controller('mainController', function($scope,empleadosFunctions) {
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