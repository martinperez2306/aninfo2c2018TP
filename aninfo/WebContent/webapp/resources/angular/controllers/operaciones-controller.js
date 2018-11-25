var app = angular.module('aninfoApp', ['proyectosModule']);
var scope = {};

app.factory('operacionesFunctions',function($http){
	
	return{
	}
})
.controller('operacionesController', function($scope,$location,proyectosFunctions) {
    scope = $scope;
    
    $scope.proyectos = [];
    $scope.urlEmpleado = $location.absUrl().split("/")[4];
    $scope.dniEmpleado = $location.absUrl().split("/")[5];
    
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