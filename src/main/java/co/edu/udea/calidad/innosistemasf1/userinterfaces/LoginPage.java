package co.edu.udea.calidad.innosistemasf1.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage {

    // Campo para poner correo electrónico (en el formulario de login)
    public static final Target CAMPO_CORREO = Target.the("campo de correo electrónico")
            .located(By.cssSelector("input[placeholder='@udea.edu.co']"));

    // Campo para poner contraseña (en el formulario de login)
    public static final Target CAMPO_CONTRASENA = Target.the("campo de contraseña")
            .located(By.cssSelector("input[placeholder='Contraseña']"));

    // Botón de inicio de sesión dentro del formulario de login
    public static final Target BOTON_INICIAR_SESION_FORMULARIO = Target.the("botón Iniciar Sesión del formulario")
            .located(By.cssSelector("button.bg-blue-600.hover\\:bg-blue-700.text-white.font-bold.py-3.px-4.rounded-md.w-full.text-xl.sm\\:text-2xl.mt-8.transition.duration-300.ease-in-out.disabled\\:opacity-50.disabled\\:cursor-not-allowed "));

    // Selector actualizado para el mensaje de error de credenciales inválidas

    public static final Target MENSAJE_ERROR_CREDENCIALES = Target.the("mensaje de error de credenciales")
            .located(By.cssSelector("p.text-red-500.text-center.mb-4"));



}