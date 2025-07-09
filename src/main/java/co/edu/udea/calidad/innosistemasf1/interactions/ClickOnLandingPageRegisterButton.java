package co.edu.udea.calidad.innosistemasf1.interactions;

import co.edu.udea.calidad.innosistemasf1.userinterfaces.WelcomePage; // Importar WelcomePage
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;


import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ClickOnLandingPageRegisterButton implements Interaction {

    @Override
    @Step("{0} hace clic en el botón 'Registrarse' de la página principal")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(WelcomePage.BOTON_REGISTRARSE, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(WelcomePage.BOTON_REGISTRARSE)
        );
    }

    public static ClickOnLandingPageRegisterButton toNavigateToRegister() {
        return instrumented(ClickOnLandingPageRegisterButton.class);
    }
}