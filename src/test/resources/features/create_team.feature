# language: en
Feature: Creación de un nuevo equipo
  Como usuario logueado en el dashboard
  Quiero crear un nuevo equipo
  Para organizar proyectos y miembros

  Scenario: Creación de equipo exitosa
    Given que el estudiante ha iniciado sesión y está en el Dashboard
    When navega a la página de creación de equipo
    And crea un equipo llamado "Equipo QA Automatizacion" con el líder "Nuevo Estudiante"
    Then el sistema debería mostrar un mensaje de éxito de creación de equipo