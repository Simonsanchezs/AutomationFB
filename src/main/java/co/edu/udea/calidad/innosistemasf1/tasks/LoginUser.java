package co.edu.udea.calidad.innosistemasf1.tasks;

import co.edu.udea.calidad.innosistemasf1.userinterfaces.LoginPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;


import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class LoginUser implements Task {

    private final String username;
    private final String password;

    public LoginUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static LoginUser with(String username, String password) {
        return instrumented(LoginUser.class, username, password);
    }

    @Override
    @Step("{0} intenta iniciar sesión con el usuario '#username' y contraseña")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(LoginPage.CAMPO_CORREO, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(username).into(LoginPage.CAMPO_CORREO),
                Enter.theValue(password).into(LoginPage.CAMPO_CONTRASENA),
                Click.on(LoginPage.BOTON_INICIAR_SESION_FORMULARIO)
        );
    }
}