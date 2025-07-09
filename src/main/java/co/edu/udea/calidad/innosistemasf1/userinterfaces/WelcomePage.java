package co.edu.udea.calidad.innosistemasf1.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class WelcomePage {

    // Botón "Iniciar sesión" en la página principal (Landing Page)
    public static final Target BOTON_INICIAR_SESION = Target.the("botón Iniciar Sesión en la página principal")
            .located(By.cssSelector("button.px-16.py-7.max-w-full.text-4xl.font-light.text-black.bg-white.rounded-md.border-solid.border-\\[3px\\].border-slate-400.w-\\[394px\\]"));

    // Botón "Registrarse" en la página principal (Landing Page)
    public static final Target BOTON_REGISTRARSE = Target.the("botón Registrarse en la página principal")
            .located(By.cssSelector("button.px-16.pt-7.pb-4.mt-7.max-w-full.text-4xl.font-light.text-white.whitespace-nowrap.rounded-md.bg-slate-400.w-\\[396px\\]"));

}