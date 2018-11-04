var app = angular.module('aninfoApp', []);


app.factory('loadHoursFunctions',function($http){
	
	var loadHours = function(cargaDeHoras, callback){
		$http({
			method: 'POST',
			data:cargaDeHoras,
			url: '/aninfo/hour'
		}).then(function(response){
			callback(response);
		})
	}
	
	var getHours = function(cargaDeHoras, callback){
		$http({
			method: 'GET',
			url: '/aninfo/hour'
		}).then(function(response){
			callback(response);
		})
	}
	
	return{
		loadHours:loadHours
	}
})
.controller('mainController', function($scope,loadHoursFunctions) {
    $scope.name = "";
    
    $scope.init = function(){
    	$scope.newLoad = {
    			cantidadDeHoras:0,
    			dia:0,
    			mes:0,
    			anio:0
    		}
    }    
        
    $scope.cargarHoras = function(){
    	loadHoursFunctions.loadHours($scope.newLoad,function(response){
    		console.log("Recibiendo respuesta");
    		console.log(response);
    	})
    }
    
    
});