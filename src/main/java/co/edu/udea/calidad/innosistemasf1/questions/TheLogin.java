package co.edu.udea.calidad.innosistemasf1.questions;

import co.edu.udea.calidad.innosistemasf1.userinterfaces.DashboardPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;



public class TheLogin implements Question<Boolean> {

    @Override
    @Step("{0} verifica si el login fue exitoso porque el elemento del dashboard es visible")
    public Boolean answeredBy(Actor actor) {

        boolean dashboardElementIsVisible = DashboardPage.DASHBOARD_MENU_ITEM.resolveFor(actor).isVisible();

        return dashboardElementIsVisible;
    }

    public static TheLogin wasSuccessful() {
        return new TheLogin();
    }
}