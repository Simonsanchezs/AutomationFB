package co.edu.udea.calidad.innosistemasf1.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CreateTeamPage {

    public static final Target CAMPO_NOMBRE_EQUIPO = Target.the("campo para el nombre del equipo")
            .located(By.id("teamNameInput"));

    public static final Target SELECTOR_LIDER = Target.the("selector de líder")
            .located(By.id("leaderSelect"));

    // Selector para el botón "Continuar" del formulario


    public static final Target BOTON_CONTINUAR = Target.the("botón Continuar")
            .located(By.xpath("//button[contains(.,'Continuar')]"));


    public static final Target MENSAJE_EXITO_CREACION_EQUIPO = Target.the("mensaje de éxito de creación de equipo")
            .located(By.xpath("//h2[contains(.,'¡Equipo creado exitosamente!')]"));
}