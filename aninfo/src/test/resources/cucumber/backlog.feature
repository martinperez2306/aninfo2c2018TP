Feature: Backlog de Tareas
  Como desarrollador 
  quiero contar con un backlog de mis tareas asignadas 
  para poder organizar mejor mi tiempo y evitar la sobrecarga de trabajo.


  Scenario: Desarrollador consulta el Backlog de Tareas
    Given un desarrollador que revisa sus Tareas
    When quiere ver el estado de sus tareas
    Then se le presenta una vista en forma de backlog que informa si una tarea fue completada o no