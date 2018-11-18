Feature: Checklist de Tareas
  Como desarrollador
  quiero contar con una checklist de mis tareas asignadas 
  para poder organizar mejor mi tiempo y evitar la sobrecarga de trabajo.

  Scenario: Desarrollador consulta el listado de tareas
    Given un desarrollador
    When quiere ver el estado de sus tareas
    Then se le presenta una vista en forma de checklist que informa si una tarea fue completada o no.
    
  Scenario: Desarrollador actualiza el checklist completando una tarea
    Given un desarrollador
    When completa una tarea
    Then se le presenta el checklist actualizado mostrando las tareas completas e incompletas.