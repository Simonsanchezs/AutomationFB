package co.edu.udea.calidad.innosistemasf1.tasks;

import co.edu.udea.calidad.innosistemasf1.interactions.ClickOnCreateTeamButton;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;


import static net.serenitybdd.screenplay.Tasks.instrumented;

public class NavigateToCreateTeamPage implements Task {

    public NavigateToCreateTeamPage() {
        // Constructor vacío si no hay parámetros específicos de navegación.

    }

    public static NavigateToCreateTeamPage fromDashboard() {
        return instrumented(NavigateToCreateTeamPage.class);
    }

    @Override
    @Step("{0} navega a la página de creación de equipo desde el Dashboard")
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                ClickOnCreateTeamButton.onDashboard()
        );
    }
}