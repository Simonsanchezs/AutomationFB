package co.edu.udea.calidad.innosistemasf1.tasks;

import co.edu.udea.calidad.innosistemasf1.userinterfaces.CreateTeamPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.waits.WaitUntil;


import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CreateTeam implements Task {

    private final String teamName;
    private final String leaderName;

    public CreateTeam(String teamName, String leaderName) {
        this.teamName = teamName;
        this.leaderName = leaderName;
    }

    public static CreateTeam withDetails(String teamName, String leaderName) {
        return instrumented(CreateTeam.class, teamName, leaderName);
    }

    @Override
    @Step("{0} crea un equipo con nombre '#teamName' y líder '#leaderName'")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(CreateTeamPage.CAMPO_NOMBRE_EQUIPO, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(teamName).into(CreateTeamPage.CAMPO_NOMBRE_EQUIPO),
                SelectFromOptions.byVisibleText(leaderName).from(CreateTeamPage.SELECTOR_LIDER),
                Click.on(CreateTeamPage.BOTON_CONTINUAR)
        );
    }
}