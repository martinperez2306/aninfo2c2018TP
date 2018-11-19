Feature: Checklist por Tarea
  Como desarrollador 
  quiero contar con una checklist por tarea 
  para poder estimar mejor el tiempo empleado y faltante.

  Scenario: Desarrollador consulta el listado de tareas
    Given un desarrollador
    When quiere ver el estado de sus tareas
    Then se le presenta una vista en forma de checklist que contiene todos los pasos que determinan a una tarea
    
  Scenario: Desarrollador actualiza el checklist completando una tarea
    Given un desarrollador
    When completa una tarea
    Then se le presenta el checklist actualizado mostrando las tareas completas e incompletas