var app = angular.module('aninfoApp', ['proyectosModule','tareasModule','asignacionesModule']);
var scope = {};

app.factory('hoursFunctions',function($http){
	
	var loadHours = function(cargaDeHoras, callback){
		$http({
			method: 'POST',
			data:cargaDeHoras,
			url: '/aninfo/hours'
		}).then(function(response){
			callback(response);
		})
	}
	
	var getHours = function(callback){
		$http({
			method: 'GET',
			url: '/aninfo/hours'
		}).then(function(response){
			callback(response);
		})
	}
	
	return{
		loadHours:loadHours,
		getHours:getHours
	}
})
.controller('cargaHorasController', function($scope,$location,hoursFunctions,proyectosFunctions,tareasFunctions,asignacionesFunctions) {
    scope = $scope;
    
    Hora = function(horaView){
    	var self = this;
    	self.cantidadDeHoras = horaView.cantidadDeHoras;
    	self.fecha = new Date(horaView.fecha);
    	self.proyecto = horaView.proyecto;
    	self.empleado = horaView.empleado;
    	self.tarea = horaView.codigoTarea;
    	self.descripcion = horaView.descripcion;
    }
    
    $scope.urlEmpleado = $location.absUrl().split("/")[4];
    $scope.dniEmpleado = $location.absUrl().split("/")[5];
    
    $scope.asignaciones = [];
    $scope.proyectos = [];
    $scope.tareas = [];
    $scope.hours = [];
    
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
    	
    	asignacionesFunctions.getAsignacionesEmpleado($scope.dniEmpleado,function(response){
    		angular.forEach(response.data, function(asignacion){
    			$scope.asignaciones.push(asignacion);
    		})
    		
    		proyectosFunctions.getProyectos(function(response){
    			angular.forEach(response.data, function(proyecto){
    				angular.forEach($scope.asignaciones,function(asignacion){
    					if(asignacion.codigoProyecto == proyecto.codigo){
    						$scope.proyectos.push(proyecto);
    					}
    				})
    			})
    		})
    	
    		tareasFunctions.getTareas(function(response){
    			angular.forEach(response.data, function(tarea){
    				angular.forEach($scope.asignaciones,function(asignacion){
    					if(asignacion.codigoTarea == tarea.codigo){
    						$scope.tareas.push(tarea);
    					}
    				})
    			})
    		})
    	})
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
    		tarea:form.tarea.nombre
    	}
    	hoursFunctions.loadHours(cargaDeHoras,function(response){
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
    
    $scope.consultarHoras = function(){
    	hoursFunctions.getHours(function(response){
    		angular.forEach(response.data, function(hour){
    			var hora = new Hora(hour);
    			$scope.hours.push(hora);
    		})
    	})
    }
    
});