package co.edu.udea.calidad.innosistemasf1.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SignUpPage {

    // Campos del formulario de registro
    public static final Target CAMPO_NOMBRE = Target.the("campo de nombre")
            .located(By.name("nombre"));

    public static final Target CAMPO_CORREO_REGISTRO = Target.the("campo de correo electrónico para registro")
            .located(By.name("email"));

    public static final Target CAMPO_CONTRASENA_REGISTRO = Target.the("campo de contraseña para registro")
            .located(By.name("contrasena"));

    public static final Target CAMPO_CONFIRMAR_CONTRASENA = Target.the("campo de confirmar contraseña")
            .located(By.name("confirmarContrasena"));

    // Botón "Crear cuenta"
    public static final Target BOTON_CREAR_CUENTA = Target.the("botón Crear cuenta")
            .located(By.cssSelector("button[type='submit'].w-full.text-white.py-2.rounded.bg-blue-600"));




    // Mensaje de éxito de registro
    public static final Target MENSAJE_EXITO_REGISTRO = Target.the("mensaje de éxito de registro")
            .located(By.cssSelector("div.mb-4.p-3.bg-green-100.text-green-700.rounded.border.border-green-200"));

    // Mensaje de error de registro
    public static final Target MENSAJE_ERROR_REGISTRO = Target.the("mensaje de error de registro")
            .located(By.cssSelector("div.text-red-500.mb-4"));
}