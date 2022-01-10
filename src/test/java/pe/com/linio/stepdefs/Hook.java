package pe.com.linio.stepdefs;

import mail.MailSender;
import managers.DriverManager;
import managers.GlobalParams;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hook {
    public static GlobalParams params = new GlobalParams();
    public static DriverManager driverManager = new DriverManager();

    @Before
    public static void startTests() {
        params.inicializaParametrosGlobales();
        driverManager.initDriver();
    }

    @After
    public static void tearDown() {
        driverManager.getDriver().quit();
    }

    @AfterStep
    public void takeScreenshoot(Scenario scenario) {
        byte[] screenshot = ((TakesScreenshot) new DriverManager().getDriver()).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", scenario.getName());

    }
}
