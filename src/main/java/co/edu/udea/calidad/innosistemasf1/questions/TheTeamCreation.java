package co.edu.udea.calidad.innosistemasf1.questions;

import co.edu.udea.calidad.innosistemasf1.userinterfaces.CreateTeamPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;


public class TheTeamCreation implements Question<Boolean> {

    @Override
    @Step("{0} verifica si el equipo fue creado exitosamente")
    public Boolean answeredBy(Actor actor) {

        return CreateTeamPage.MENSAJE_EXITO_CREACION_EQUIPO.resolveFor(actor).isVisible();
    }

    public static TheTeamCreation wasSuccessful() {
        return new TheTeamCreation();
    }
}