Feature: Asignacion de Tareas
  Como gerente de operaciones
  quiero poder asignarle a los desarrolladores las tareas que les corresponden (individualmente) 
  para que puedan trabajar de manera más eficiente y ordenada.

  Scenario: Gerente asigna tareas a desarrolladores
    Given un gerente de operaciones
    When quiere distribuir las tareas
    Then elige para cada tarea un desarrollador que la tendrá asignada.
    
  Scenario: Desarrollador informado sobre la tarea asignada
    Given un gerente de operaciones
    When asigna una tarea
    Then se le informa al desarrollador en el checklist actualizado mostrando la nueva tarea asignada.
  
  Scenario: Gerente re asinga una tarea
    Given un gerente de operaciones
    When re asigna una tarea, por ejemplo en un cambio de horas,
    Then se le informa al desarrollador sobre los cambios en la tarea.
    
  Scenario: Gerente re asinga una tarea
    Given un gerente de operaciones
    When re asigna una tarea, por ejemplo en un cambio de tarea,
    Then se le informa al desarrollador sobre los cambios en la tarea.
    
  Scenario: Gerente re asinga una tarea
    Given un gerente de operaciones
    When re asigna una tarea, por ejemplo en un cambio desarrollador,
    Then se le informa a los desarrolladores sobre los cambios en la tarea.