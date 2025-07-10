package co.edu.udea.calidad.innosistemasf1.stepdefinitions;

import co.edu.udea.calidad.innosistemasf1.questions.TheRegistration;
import co.edu.udea.calidad.innosistemasf1.questions.TheSignUpErrorMessage;
import co.edu.udea.calidad.innosistemasf1.tasks.NavigateToRegister;
import co.edu.udea.calidad.innosistemasf1.tasks.RegisterUser;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

public class RegisterStepDefinition {

    @Managed(driver = "chrome")
    WebDriver hisBrowser;

    private Actor estudiante;

    @Before
    public void setupActor() {
        OnStage.setTheStage(new OnlineCast()); // Prepara el escenario para los actores
        // Aquí definimos al actor "Estudiante" y le damos la habilidad de navegar
        estudiante = theActorCalled("Estudiante").can(BrowseTheWeb.with(hisBrowser));
    }

    @Given("el estudiante se encuentra en la página de registro de InnoSistemas UdeA")
    public void elEstudianteSeEncuentraEnLaPaginaDeRegistroDeInnoSistemasUdeA() {
        // El actor 'estudiante' intenta navegar a la página de registro desde la landing page
        estudiante.attemptsTo(NavigateToRegister.fromLandingPage("http://localhost:3000/"));
    }

    @When("ingresa el nombre {string} y el correo {string} y la contraseña {string} y confirma la contraseña {string}")
    public void ingresaTodosLosCamposYConfirmaContrasena(String name, String email, String password, String confirmPassword) {
        // El actor 'estudiante' intenta registrarse con los detalles proporcionados
        estudiante.attemptsTo(
                RegisterUser.withDetails(name, email, password, confirmPassword)
        );
    }

    @Then("el sistema debería mostrar un mensaje de éxito de registro")
    public void elSistemaDeberiaMostrarUnMensajeDeExitoDeRegistro() {
        // El actor 'estudiante' debería verificar que el registro fue exitoso
        estudiante.should(seeThat(TheRegistration.wasSuccessful(), is(true)));
    }

    @Then("el sistema debería mostrar un mensaje de error indicando {string}")
    public void elSistemaDeberiaMostrarUnMensajeDeErrorIndicando(String expectedErrorMessage) {
        // El actor 'estudiante' debería verificar que el mensaje de error de registro es visible y contiene el texto esperado
        estudiante.should(
                seeThat(TheSignUpErrorMessage.isVisible(), is(true)),
                seeThat(TheSignUpErrorMessage.displayed(), containsString(expectedErrorMessage))
        );
    }
}