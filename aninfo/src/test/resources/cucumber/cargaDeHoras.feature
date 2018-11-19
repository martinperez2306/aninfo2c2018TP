Feature: Carga de Horas
  Como desarrollador
  quiero poder registrar la cantidad de horas de mi trabajo
  para que se vean reflejadas en el estado de cada proyecto.

  Scenario: Cargar Horas
    Given el desarrollador "mperez"
    When carga las horas de su trabajo siendo 5 horas en "psaSpringERP" y 3 horas en "psaSpringCRM"
    Then ha cargado un total de 8 horas reflejando el trabajo en cada proyecto

  Scenario: No cargar mas de las horas disponibles en el dia
    Given el desarrollador "nlongo"
    When carga 5 horas en "psaSpringERP" y 5 en "psaSpringERP" pero su jornada laboral es de 8 horas
    Then le avisa que no puede cargar mas horas