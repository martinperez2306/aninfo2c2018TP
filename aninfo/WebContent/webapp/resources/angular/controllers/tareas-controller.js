var app = angular.module('aninfoApp', ['proyectosModule','tareasModule']);
var scope = {};

app.controller('tareasController', function($scope,$location,proyectosFunctions,tareasFunctions) {
    scope = $scope;
    
    $scope.dniEmpleado = $location.absUrl().split("/")[5];
    $scope.codigoProyecto = $location.absUrl().split("/")[6];
    
    $scope.proyecto = {};
    $scope.tareas = [];
    
    NuevaTarea = function(){
    	var self =this;
    	self.codigo = "";
    	self.nombre = "";
    	self.descripcion="";
    	self.edit = false;
    }
    
    Tarea = function(nuevaTarea){
    	var self =this;
    	self.codigo = nuevaTarea.codigo;
    	self.nombre = nuevaTarea.nombre;
    	self.descripcion=nuevaTarea.descripcion;
    }
    
    $scope.init = function(){
    	proyectosFunctions.getProyecto($scope.codigoProyecto, function(response){
    		$scope.proyecto = response.data;
    	})
    	
    	tareasFunctions.getTareas(function(response){
    		angular.forEach(response.data, function(tarea){
    			if(tarea.codigoProyecto == $scope.codigoProyecto){
    				$scope.tareas.push(tarea);
    			}
    		})
    	})
    }
    
    $scope.agregarTarea = function(){
    	$scope.nuevaTarea = new NuevaTarea();
    	$scope.nuevaTarea.edit = true;
    }
    
    $scope.aceptarNuevaTarea = function(){
    	var tarea = new Tarea($scope.nuevaTarea);
    	tareasFunctions.addTarea(tarea,function(response){
    		$scope.nuevaTarea = new NuevaTarea();
    	})
    }
    
    $scope.cancelarNuevaTarea = function(){
    	$scope.nuevaTarea.edit = false;
    }
    
    $scope.borrarTarea = function(tarea){
    	tareasFunctions.deleteTarea(tarea,function(response){
    		$scope.cargarTareas();
    	})
    }
    
    $scope.cargarTareas = function(){
    	$scope.tareas = [];
    	tareasFunctions.getTareas(function(response){
    		angular.forEach(response.data, function(tarea){
    			$scope.tareas.push(tarea);
    		})
    	})
    }
});