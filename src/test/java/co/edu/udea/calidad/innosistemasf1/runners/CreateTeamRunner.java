package co.edu.udea.calidad.innosistemasf1.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/create_team.feature", // Ruta al feature de creación de equipo
        glue = "co.edu.udea.calidad.innosistemasf1.stepdefinitions", // Paquete de Step Definitions
        snippets = CucumberOptions.SnippetType.CAMELCASE

)
public class CreateTeamRunner {
}