package co.edu.udea.calidad.innosistemasf1.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class DashboardPage {

    // Elemento "Dashboard" visible después del login exitoso
    public static final Target DASHBOARD_MENU_ITEM = Target.the("elemento del menú Dashboard")
            .located(By.xpath("//a[@href='/dashboard']/button/span[text()='Dashboard']"));

    // Botón "Crear equipo" en el Dashboard
    public static final Target BOTON_CREAR_EQUIPO = Target.the("botón Crear equipo en el Dashboard")
            .located(By.xpath("//a[@href='/crearEquipo']/button/span[text()='Crear equipo']"));
    // Selector XPath para el enlace <a> que contiene el botón con el texto 'Crear equipo'.
}