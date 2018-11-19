var app = angular.module('aninfoApp', []);
var scope = {};

app.factory('loadHoursFunctions',function($http){
	
	var loadHours = function(cargaDeHoras, callback){
		$http({
			method: 'POST',
			data:cargaDeHoras,
			url: '/aninfo/hours'
		}).then(function(response){
			callback(response);
		})
	}
	
	var getHours = function(cargaDeHoras, callback){
		$http({
			method: 'GET',
			url: '/aninfo/hours'
		}).then(function(response){
			callback(response);
		})
	}
	
	return{
		loadHours:loadHours
	}
})
.controller('cargaHorasController', function($scope,loadHoursFunctions) {
    scope = $scope;
    $scope.init = function(){
    	$scope.horasCargadas = {
    		cantidadDeHoras:0,
    		dia:0,
    		mes:0,
    		anio:0,
    		descripcion:"",
    		empleado:"",
    		tarea:"",
    		proyecto:"",
    		selectedDate:new Date(),
    		horaInicial:0,
    		minutoInicial:0,
    		horaFinal:0,
    		minutoFinal:0
    	}
    }    
        
    $scope.cargarHoras = function(){
    	var form = $scope.horasCargadas;
    	var cargaDeHoras = {
    		cantidadDeHoras:form.cantidadDeHoras,
    		anio: form.selectedDate.getFullYear(),
    		mes: form.selectedDate.getMonth() + 1,
    		dia: form.selectedDate.getDate(),
    		descripcion:form.descripcion,
    		empleado:form.empleado,
    		proyecto:form.proyecto,
    		tarea:form.tarea
    	}
    	loadHoursFunctions.loadHours(cargaDeHoras,function(response){
    		console.log("Recibiendo respuesta");
    		console.log(response);
    	})
    }
    
    $scope.calcularTotal = function(){
    	var form = $scope.horasCargadas;
    	if(form.horaFinal > form.horaInicial){
    		form.cantidadDeHoras = form.horaFinal - form.horaInicial;
    	}
    }
    
});