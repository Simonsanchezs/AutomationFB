package co.edu.udea.calidad.innosistemasf1.questions;

import co.edu.udea.calidad.innosistemasf1.userinterfaces.SignUpPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;


public class TheRegistration implements Question<Boolean> {

    @Override
    @Step("{0} verifica si el registro fue exitoso")
    public Boolean answeredBy(Actor actor) {
        return SignUpPage.MENSAJE_EXITO_REGISTRO.resolveFor(actor).isVisible();
    }

    public static TheRegistration wasSuccessful() {
        return new TheRegistration();
    }
}