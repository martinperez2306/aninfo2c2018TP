Feature: Carga de Horas
  Como desarrollador
  quiero poder registrar la cantidad de horas de mi trabajo
  para que se vean reflejadas en el estado de cada proyecto.

  Scenario: Cargar Horas
    Given un desarrollador
    When carga las horas de su trabajo
    Then quedan registradas dando informacion de la tarea realizada sobre un determinado proyecto

  Scenario: No cargar mas de las horas disponibles en el dia
    Given un desarrollador
    When carga mas horas de las que tiene disponibles en el dia
    Then le avisa que no puede cargar mas horas