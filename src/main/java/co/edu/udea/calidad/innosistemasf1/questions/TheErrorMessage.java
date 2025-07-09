package co.edu.udea.calidad.innosistemasf1.questions;

import co.edu.udea.calidad.innosistemasf1.userinterfaces.LoginPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;


public class TheErrorMessage implements Question<String> {

    @Override
    @Step("{0} obtiene el mensaje de error de credenciales inválidas")
    public String answeredBy(Actor actor) {
        // Solo intenta obtener el texto si el elemento del mensaje de error es visible
        if (LoginPage.MENSAJE_ERROR_CREDENCIALES.resolveFor(actor).isVisible()) {
            return Text.of(LoginPage.MENSAJE_ERROR_CREDENCIALES).answeredBy(actor);
        }
        return ""; // Retorna un string vacío si el elemento no es visible
    }

    public static Question<String> displayed() {
        return new TheErrorMessage();
    }

    public static Question<Boolean> isVisible() {
        // Pregunta simple para verificar solo la visibilidad del mensaje de error
        return actor -> LoginPage.MENSAJE_ERROR_CREDENCIALES.resolveFor(actor).isVisible();
    }
}