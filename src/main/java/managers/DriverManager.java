package managers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import utils.TestUtils;

/**
 * Gestiona drivers que inicia los navegadores
 */
public class DriverManager {
    private static ThreadLocal<WebDriver> driver;
    static TestUtils utils;
    public WebDriver getDriver(){
        return driver.get();
    }

    public void setDriver(WebDriver drvr){
        driver.set(drvr);
    }

    public void initDriver(){
        driver = new ThreadLocal<>();
        utils = new TestUtils();

        WebDriver driverlocal = null;
        GlobalParams params = new GlobalParams();

        // Opciones con que se inician los navegadores
        ChromeOptions optionsChrome = new ChromeOptions();
        FirefoxOptions optionsFirefox = new FirefoxOptions();
        EdgeOptions optionsEdge = new EdgeOptions();
        SafariOptions optionsSafari = new SafariOptions();

        optionsChrome
                .addArguments("start-maximized");

        try {
            switch (params.getNavigatorDriver()){
                case "Chrome":
                    WebDriverManager.chromedriver().setup();
                    driverlocal = new ChromeDriver(optionsChrome);
                    break;
                case "Firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driverlocal = new FirefoxDriver(optionsFirefox);
                    break;
                case "Safari":
                    WebDriverManager.safaridriver().setup();
                    driverlocal = new SafariDriver(optionsSafari);
                    break;
                case "Edge":
                    WebDriverManager.safaridriver().setup();
                    driverlocal = new EdgeDriver(optionsEdge);
                    break;
            }

            if (driverlocal != null){
                driverlocal.get(params.getWebTestURL());
                setDriver(driverlocal);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
