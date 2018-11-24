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
    
    NuevoProyecto = function(){
    	var self = this;
    	self.codigo = "";
    	self.vencimiento = "";
    	self.fechaEntrega = new Date();
    	selfpresupuesto = "";
    	self.edit = false;
    }
    
    Proyecto = function(nuevoProyecto){
    	var self = this;
    	self.codigo = nuevoProyecto.codigo;
    	self.vencimiento = nuevoProyecto.vencimiento;
    	self.fechaEntrega = nuevoProyecto.fechaEntrega.getDate() + "/" 
    	+ nuevoProyecto.fechaEntrega.getMonth() + "/" 
    	+ nuevoProyecto.fechaEntrega.getFullYear();
    	self.presupuesto = nuevoProyecto.presupuesto;
    }
    
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
    	
    	empleadosFunctions.getDesarrolladores(function(response){
    		angular.forEach(response.data, function(empleado){
    			$scope.empleados.push(empleado);
    		})
    	})
    }
    
    $scope.agregarProyecto = function(){
    	$scope.nuevoProyecto = new NuevoProyecto();
    	$scope.nuevoProyecto.edit = true;
    }
    
    $scope.aceptarNuevoProyecto = function(){
    	var proyecto = new Proyecto($scope.nuevoProyecto);
    	proyectosFunctions.addProyecto(proyecto,function(response){
    		$scope.nuevoProyecto = new NuevoProyecto();
    	})
    }
    
    $scope.cancelarNuevoProyecto = function(){
    	$scope.nuevoProyecto.edit = false;
    }
    
    $scope.borrarProyecto = function(proyecto){
    	proyectosFunctions.deleteProyecto(proyecto,function(response){
    		$scope.cargarProyectos();
    	})
    }
    
    $scope.cargarProyectos = function(){
    	$scope.proyectos = [];
    	proyectosFunctions.getProyectos(function(response){
    		angular.forEach(response.data, function(proyecto){
    			$scope.proyectos.push(proyecto);
    		})
    	})
    }
});