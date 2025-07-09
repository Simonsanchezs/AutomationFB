package co.edu.udea.calidad.innosistemasf1.tasks;

import co.edu.udea.calidad.innosistemasf1.interactions.ClickOnLandingPageLoginButton;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;


import static net.serenitybdd.screenplay.Tasks.instrumented;

public class NavigateToLogin implements Task {

    private final String landingPageUrl;

    public NavigateToLogin(String landingPageUrl) {
        this.landingPageUrl = landingPageUrl;
    }

    public static NavigateToLogin fromLandingPage(String landingPageUrl) {
        return instrumented(NavigateToLogin.class, landingPageUrl);
    }

    @Override
    @Step("{0} navega a la página de login desde la página principal")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                OpenTheBrowser.onThePage(landingPageUrl),
                ClickOnLandingPageLoginButton.toNavigateToLogin()
        );
    }
}