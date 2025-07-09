# language: en
Feature: Registro de usuarios en InnoSistemas UdeA
  Como nuevo estudiante
  Quiero registrar una cuenta en el portal
  Para poder iniciar sesión y acceder a los recursos

  Scenario: Registro de usuario exitoso
    Given el estudiante se encuentra en la página de registro de InnoSistemas UdeA
    When ingresa el nombre "simon" y el correo "simone.estudiante@mail.com" y la contraseña "NuevaContrasena1232." y confirma la contraseña "NuevaContrasena1232."
    Then el sistema debería mostrar un mensaje de éxito de registro

  Scenario: Intento de registro con correo ya existente
    Given el estudiante se encuentra en la página de registro de InnoSistemas UdeA
    When ingresa el nombre "pedro" y el correo "pedro@udea.edu.co" y la contraseña "Existente123." y confirma la contraseña "Existente123."
    Then el sistema debería mostrar un mensaje de error indicando "Unexpected error."

  Scenario: Intento de registro con contraseñas que no coinciden
    Given el estudiante se encuentra en la página de registro de InnoSistemas UdeA
    When ingresa el nombre "Usuario Prueba" y el correo "usuario.prueba@mail.com" y la contraseña "ContrasenaA1." y confirma la contraseña "ContrasenaB2."
    Then el sistema debería mostrar un mensaje de error indicando "Las contraseñas no coinciden"