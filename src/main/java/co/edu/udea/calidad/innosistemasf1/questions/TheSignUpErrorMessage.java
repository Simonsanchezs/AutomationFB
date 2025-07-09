package co.edu.udea.calidad.innosistemasf1.questions;

import co.edu.udea.calidad.innosistemasf1.userinterfaces.SignUpPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;


public class TheSignUpErrorMessage implements Question<String> {

    @Override
    @Step("{0} obtiene el mensaje de error de registro")
    public String answeredBy(Actor actor) {
        if (SignUpPage.MENSAJE_ERROR_REGISTRO.resolveFor(actor).isVisible()) {
            return Text.of(SignUpPage.MENSAJE_ERROR_REGISTRO).answeredBy(actor);
        }
        return "";
    }

    public static Question<String> displayed() {
        return new TheSignUpErrorMessage();
    }

    public static Question<Boolean> isVisible() {
        return actor -> SignUpPage.MENSAJE_ERROR_REGISTRO.resolveFor(actor).isVisible();
    }
}