Feature: Alertas
  Como desarrollador 
  quiero recibir alertas cuando se está acercando el vencimiento de una tarea 
  para estar al tanto de las tareas con más prioridad. 

  Scenario: Tarea proxima a su vencimiento
    Given un desarrollador
    When quiere saber el vencimiento de sus tareas
    Then se le presentan alertas que indican que se acerca el vencimiento de una tarea. 
    
  Scenario: Tarea proxima a su vencimiento sin revision del desarrollador
    Given un desarrollador
    When se acerca el vencimiento de una de sus tareas
    Then se le alerta de forma inmediata que se aproxima el vencimiento de una tarea. 