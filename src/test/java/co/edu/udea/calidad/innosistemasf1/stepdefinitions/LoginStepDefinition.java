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
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.screenplay.waits.WaitUntil;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import java.time.Duration;

import co.edu.udea.calidad.innosistemasf1.userinterfaces.LoginPage;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;


public class LoginStepDefinition {

    @Managed(driver = "chrome")
    WebDriver hisBrowser;

    private Actor estudiante;

    @Before
    public void setupActor() {
        OnStage.setTheStage(new OnlineCast());
        // definimos  al actor y le damos la habilidad de navegar
        estudiante = theActorCalled("Estudiante").can(BrowseTheWeb.with(hisBrowser));
    }

    @Given("el estudiante se encuentra en la página de login de InnoSistemas UdeA")
    public void elEstudianteSeEncuentraEnLaPaginaDeLoginDeInnoSistemasUdeA() {
        // El actor 'estudiante' intenta navegar a la página de login
        estudiante.attemptsTo(NavigateToLogin.fromLandingPage("http://localhost:3000/"));
    }

    @When("ingresa su correo {string} y contraseña {string} correctos")
    public void ingresaSuCorreoYContrasenaCorrectos(String email, String password) {
        // El actor 'estudiante' intenta iniciar sesión con las credenciales dadas
        estudiante.attemptsTo(LoginUser.with(email, password));
    }

    @Then("el sistema permite el acceso al {string}")
    public void elSistemaPermiteElAccesoAlDashboard(String expectedDashboardIdentifier) {
        // El actor 'estudiante' debería verificar que el login fue exitoso
        estudiante.should(
                seeThat(TheLogin.wasSuccessful(), is(true))
        );
    }

    @And("lo redirige a la página principal del dashboard")
    public void loRedirigeALaPaginaPrincipalDelDashboard() {

    }

    @When("ingresa su correo {string} y contraseña {string}")
    public void ingresaSuCorreoYContrasena(String email, String password) {
        // El actor 'estudiante' intenta iniciar sesión con las credenciales (que serán incorrectas)
        estudiante.attemptsTo(LoginUser.with(email, password));
    }

    @Then("el sistema muestra un mensaje de error indicando {string}")
    public void elSistemaMuestraUnMensajeDeErrorIndicando(String expectedErrorMessage) {
        // El actor 'estudiante' primero espera a que el mensaje de error sea visible
        estudiante.attemptsTo(
                WaitUntil.the(LoginPage.MENSAJE_ERROR_CREDENCIALES, isVisible()).forNoMoreThan(Duration.ofSeconds(10))
        );
        // Luego, el actor 'estudiante' debería verificar que el mensaje de error es visible y contiene el texto esperado
        estudiante.should(
                seeThat(TheErrorMessage.isVisible(), is(true)),
                seeThat(TheErrorMessage.displayed(), containsString(expectedErrorMessage))
        );
    }
}