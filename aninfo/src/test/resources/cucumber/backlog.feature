Feature: Backlog por Tarea
  Como desarrollador
  quiero contar con un backlog por tarea 
  para poder estimar mejor el tiempo empleado y faltante.


  Scenario: Desarrollador consulta el Backlog de una tarea
    Given un desarrollador
    When quiere ver sus tareas
    Then se le presenta una vista en forma de backlog que contiene todos los pasos que determinan a una tarea.