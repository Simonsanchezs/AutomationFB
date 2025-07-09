package co.edu.udea.calidad.innosistemasf1.interactions;

import co.edu.udea.calidad.innosistemasf1.userinterfaces.DashboardPage; // Importar DashboardPage
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;


import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ClickOnCreateTeamButton implements Interaction {

    @Override
    @Step("{0} hace clic en el botón 'Crear equipo' del dashboard")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(DashboardPage.BOTON_CREAR_EQUIPO, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(DashboardPage.BOTON_CREAR_EQUIPO)
        );
    }

    public static ClickOnCreateTeamButton onDashboard() {
        return instrumented(ClickOnCreateTeamButton.class);
    }
}