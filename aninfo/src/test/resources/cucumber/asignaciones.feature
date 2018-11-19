Feature: Asignacion de Tareas
  Como gerente de operaciones
  quiero poder asignarle a los desarrolladores las tareas que les corresponden (individualmente) 
  para que puedan trabajar de manera más eficiente y ordenada.

  Scenario: Gerente asigna tareas a desarrolladores
    Given un gerente de operaciones
    When quiere distribuir las tareas
    Then elige para cada tarea un desarrollador que la tendra asignada.
    
  Scenario: Desarrollador informado sobre la tarea asignada
    Given un gerente de operaciones
    When asigna la tarea desarrollo con codigo "01" al desarrollador "rcotarelo" para el proyecto "psaSpringCRM"
    Then queda registrada la asginacion de la tarea que luego sera mostrada al empleado "rcotarelo"
  
  Scenario: Gerente re asinga una tarea
    Given un gerente de operaciones
    When re asigna una tarea al desarrollador "rcotarelo" con codigo "02" reemplazando el codigo "01" para "psaSpringCRM"
    Then se ven impactados los cambios en la asignacion y se le informa a "rcotarelo" sobre los cambios en la tarea "02" 
    
  Scenario: Gerente re asinga una tarea
    Given un gerente de operaciones
    When re asigna una tarea al desarrollador "retchegaray" que le habia asignado a "rcotarelo"
    Then el desarrollador "rcotarelo" ya no tiene tareas asignadas