package co.edu.udea.calidad.innosistemasf1.tasks;

import co.edu.udea.calidad.innosistemasf1.userinterfaces.SignUpPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;


import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class RegisterUser implements Task {

    private final String name;
    private final String email;
    private final String password;
    private final String confirmPassword;

    public RegisterUser(String name, String email, String password, String confirmPassword) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public static RegisterUser withDetails(String name, String email, String password, String confirmPassword) {
        return instrumented(RegisterUser.class, name, email, password, confirmPassword);
    }

    @Override
    @Step("{0} intenta registrar un nuevo usuario con nombre '#name' y correo '#email'")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(SignUpPage.CAMPO_NOMBRE, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(name).into(SignUpPage.CAMPO_NOMBRE),
                Enter.theValue(email).into(SignUpPage.CAMPO_CORREO_REGISTRO),
                Enter.theValue(password).into(SignUpPage.CAMPO_CONTRASENA_REGISTRO),
                Enter.theValue(confirmPassword).into(SignUpPage.CAMPO_CONFIRMAR_CONTRASENA),
                Click.on(SignUpPage.BOTON_CREAR_CUENTA)
        );
    }
}
