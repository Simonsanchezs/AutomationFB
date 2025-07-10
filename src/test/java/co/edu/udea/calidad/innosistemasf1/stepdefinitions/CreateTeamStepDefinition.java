package co.edu.udea.calidad.innosistemasf1.stepdefinitions;

import co.edu.udea.calidad.innosistemasf1.questions.TheLogin;
import co.edu.udea.calidad.innosistemasf1.questions.TheTeamCreation;
import co.edu.udea.calidad.innosistemasf1.tasks.LoginUser;
import co.edu.udea.calidad.innosistemasf1.tasks.NavigateToLogin;
import co.edu.udea.calidad.innosistemasf1.tasks.NavigateToCreateTeamPage;
import co.edu.udea.calidad.innosistemasf1.tasks.CreateTeam;
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

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static org.hamcrest.Matchers.is;

public class CreateTeamStepDefinition {

    @Managed(driver = "chrome")
    WebDriver hisBrowser;

    private Actor estudiante;

    @Before
    public void setupActor() {
        OnStage.setTheStage(new OnlineCast()); // Prepara el escenario para los actores
        //  definimos al actor "Estudiante" y le damos la habilidad de navegar
        estudiante = theActorCalled("Estudiante").can(BrowseTheWeb.with(hisBrowser));
    }

    @Given("que el estudiante ha iniciado sesión y está en el Dashboard")
    public void queElEstudianteHaIniciadoSesionYEstaEnElDashboard() {
        // El actor  intenta navegar y luego iniciar sesión
        estudiante.attemptsTo(
                NavigateToLogin.fromLandingPage("http://localhost:3000/"),
                LoginUser.with("pedro@udea.edu.co", "simon123")
        );
        // El actor debería verificar que el login fue exitoso
        estudiante.should(seeThat(TheLogin.wasSuccessful(), is(true)));
    }

    @When("navega a la página de creación de equipo")
    public void navegaALaPaginaDeCreacionDeEquipo() {
        // El actor intenta navegar a la página de creación de equipo
        estudiante.attemptsTo(
                NavigateToCreateTeamPage.fromDashboard()
        );
    }

    @And("crea un equipo llamado {string} con el líder {string}")
    public void creaUnEquipoLlamadoConElLider(String teamName, String leaderName) {
        // El actor intenta crear un equipo con los detalles proporcionados
        estudiante.attemptsTo(
                CreateTeam.withDetails(teamName, leaderName)
        );
    }

    @Then("el sistema debería mostrar un mensaje de éxito de creación de equipo")
    public void elSistemaDeberiaMostrarUnMensajeDeExitoDeCreacionDeEquipo() {
        // El actor debería verificar que la creación del equipo fue exitosa
        estudiante.should(
                seeThat(TheTeamCreation.wasSuccessful(), is(true))
        );
    }
}