# language: en
Feature: Inicio de sesión con credenciales de la Universidad de Antioquia
Como estudiante
Quiero iniciar sesión en el portal de la universidad
Para acceder a mis recursos académicos

Scenario: Inicio de sesión exitoso
Given el estudiante se encuentra en la página de login de InnoSistemas UdeA
When ingresa su correo "pedro@udea.edu.co" y contraseña "simon123" correctos
Then el sistema permite el acceso al "Dashboard"
And lo redirige a la página principal del dashboard

Scenario: Inicio de sesión con credenciales incorrectas
Given el estudiante se encuentra en la página de login de InnoSistemas UdeA
When ingresa su correo "usuario.invalido@udea.edu.co" y contraseña "ContrasenaIncorrectaXYZ"
Then el sistema muestra un mensaje de error indicando "Unexpected error."