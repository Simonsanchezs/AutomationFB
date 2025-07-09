package co.edu.udea.calidad.innosistemasf1.stepdefinitions;

import co.edu.udea.calidad.innosistemasf1.questions.TheErrorMessage;
import co.edu.udea.calidad.innosistemasf1.questions.TheLogin;
import co.edu.udea.calidad.innosistemasf1.tasks.LoginUser;
import co.edu.udea.calidad.innosistemasf1.tasks.NavigateToLogin;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import org.openqa.selenium.WebDriver;

// Imports para la espera
import net.serenitybdd.screenplay.waits.WaitUntil;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import java.time.Duration;


import co.edu.udea.calidad.innosistemasf1.userinterfaces.LoginPage;


import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;


public class LoginStepDefinition {

    @Managed(driver = "chrome")
    WebDriver hisBrowser;

    @Before
    public void setupActor() {
        OnStage.setTheStage(new OnlineCast());
        theActorCalled("Estudiante").can(BrowseTheWeb.with(hisBrowser));
    }

    // --- Escenario: Inicio de sesión exitoso ---

    @Given("el estudiante se encuentra en la página de login de InnoSistemas UdeA")
    public void elEstudianteSeEncuentraEnLaPaginaDeLoginDeInnoSistemasUdeA() {
        theActorInTheSpotlight().attemptsTo(NavigateToLogin.fromLandingPage("http://localhost:3000/"));
    }

    @When("ingresa su correo {string} y contraseña {string} correctos")
    public void ingresaSuCorreoYContrasenaCorrectos(String email, String password) {
        theActorInTheSpotlight().attemptsTo(LoginUser.with(email, password));
    }

    @Then("el sistema permite el acceso al {string}")
    public void elSistemaPermiteElAccesoAlDashboard(String expectedDashboardIdentifier) {
        theActorInTheSpotlight().should(
                seeThat(TheLogin.wasSuccessful(), is(true))
        );
    }

    @And("lo redirige a la página principal del dashboard")
    public void loRedirigeALaPaginaPrincipalDelDashboard() {

    }

    // --- Escenario: Inicio de sesión con credenciales incorrectas ---

    @When("ingresa su correo {string} y contraseña {string}")
    public void ingresaSuCorreoYContrasena(String email, String password) {
        theActorInTheSpotlight().attemptsTo(LoginUser.with(email, password));
    }

    @Then("el sistema muestra un mensaje de error indicando {string}")
    public void elSistemaMuestraUnMensajeDeErrorIndicando(String expectedErrorMessage) {
        theActorInTheSpotlight().attemptsTo(
                // ESPERA a 10 segundos
                WaitUntil.the(LoginPage.MENSAJE_ERROR_CREDENCIALES, isVisible()).forNoMoreThan(Duration.ofSeconds(10))
        );
        theActorInTheSpotlight().should(
                seeThat(TheErrorMessage.isVisible(), is(true)),
                seeThat(TheErrorMessage.displayed(), containsString(expectedErrorMessage))
        );
    }
}