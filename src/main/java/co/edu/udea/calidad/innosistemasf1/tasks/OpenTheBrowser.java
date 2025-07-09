package co.edu.udea.calidad.innosistemasf1.tasks;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;


import static net.serenitybdd.screenplay.Tasks.instrumented;

public class OpenTheBrowser implements Task {

    private final String url;

    public OpenTheBrowser(String url) {
        this.url = url;
    }

    public static OpenTheBrowser onThePage(String url) {
        return instrumented(OpenTheBrowser.class, url);
    }

    @Override
    @Step("{0} abre el navegador en la página #url")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url(url)
        );
    }
}