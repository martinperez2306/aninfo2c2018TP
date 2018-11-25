var app = angular.module('aninfoApp', ['proyectosModule','empleadosModule','tareasModule','asignacionesModule']);
var scope = {};

app.controller('asignacionesController', function($scope,$location,asignacionesFunctions,proyectosFunctions,empleadosFunctions,tareasFunctions) {
    scope = $scope;
    
    $scope.codigoProyecto = $location.absUrl().split("/")[6];
    $scope.codigoTarea = $location.absUrl().split("/")[7];
    
    $scope.proyecto = {};
    $scope.tarea = {};
    $scope.asignaciones = [];
    $scope.empleadosDisponibles = [];
    
    NuevaAsignacion = function(){
    	var self =this;
    	self.codigoProyecto = $scope.proyecto.codigo;
    	self.codigoTarea = $scope.tarea.codigo;
    	self.dniEmpleado="";
    	self.edit = false;
    }
    
    Asignacion = function(nuevaAsignacion){
    	var self =this;
    	self.id = 0;
    	self.codigoProyecto = nuevaAsignacion.codigoProyecto;
    	self.codigoTarea = nuevaAsignacion.codigoTarea;
    	self.dniEmpleado= nuevaAsignacion.dniEmpleado;
    }
    
    $scope.init = function(){
    	
    	proyectosFunctions.getProyecto($scope.codigoProyecto,function(response){
    		$scope.proyecto = response.data;
    	})
    	
    	tareasFunctions.getTarea($scope.codigoTarea,function(response){
    		$scope.tarea = response.data;
    	})
    	
    	asignacionesFunctions.getAsignaciones(function(response){
    		angular.forEach(response.data,function(asignacion){
    			$scope.asignaciones.push(asignacion);
    		})
    	})
    	
    }
    
    $scope.agregarAsignacion = function(){
    	empleadosFunctions.getDesarrolladores(function(response){
    		angular.forEach(response.data, function(empleado){
    			$scope.empleadosDisponibles.push(empleado);
    		})
    	})
    	$scope.nuevaAsignacion = new NuevaAsignacion();
    	$scope.nuevaAsignacion.edit = true;
    }
    
    $scope.aceptarNuevaAsignacion = function(){
    	var asignacion = new Asignacion($scope.nuevaAsignacion);
    	asignacionesFunctions.addAsignacion(asignacion,function(response){
    		$scope.nuevaAsignacion = new NuevaAsignacion();
    	})
    }
    
    $scope.cancelarNuevaAsignacion = function(){
    	$scope.nuevaAsignacion.edit = false;
    }
    
    $scope.borrarAsignacion = function(asignacion){
    	asignacionesFunctions.deleteAsignacion(asignacion,function(response){
    		$scope.cargarAsignaciones();
    	})
    }
    
    $scope.cargarAsignaciones = function(){
    	$scope.asignaciones = [];
    	asignacionesFunctions.getAsignaciones(function(response){
    		angular.forEach(response.data, function(asignacion){
    			$scope.asignaciones.push(asignacion);
    		})
    	})
    }
});