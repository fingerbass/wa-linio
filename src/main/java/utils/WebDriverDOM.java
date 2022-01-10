package utils;

import managers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Se encarga de realizar acciones sobre un elemento web.
 */
public class WebDriverDOM {
    public WebDriver driver;
    public final Actions actions;
    public final TestUtils utils;

    public WebDriverDOM() {
        utils = new TestUtils();
        driver = new DriverManager().getDriver();
        driver.manage().timeouts().implicitlyWait(TestUtils.WAIT, TimeUnit.SECONDS);
        actions = new Actions(driver);

        PageFactory.initElements(driver, this);
    }

    /**
     * Espera que un objeto tipo WebElement esté visible
     */
    public void waitForVisibility(WebElement e) {
        WebDriverWait wait = new WebDriverWait(driver, TestUtils.WAIT);
        wait.until(ExpectedConditions.visibilityOf(e));
    }

    /**
     * Crea elementos web (WebElements) a partir de un hijo de un WebElement creado
     */
    public WebElement nestedWebElement(WebElement elemento, String subelemento) {
        WebDriverWait wait = new WebDriverWait(driver, TestUtils.WAIT);
        wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(elemento, By.xpath(subelemento)));
        WebElement we = elemento.findElement(By.xpath(subelemento));
        return we;
    }

    public void waitForVisibility(By e) {
        WebDriverWait wait = new WebDriverWait(driver, TestUtils.WAIT);
        wait.until(ExpectedConditions.visibilityOfElementLocated(e));
    }

    /**
     * Limpia los datos de un objeto WebElement
     */
    public void clear(WebElement e) {
        waitForVisibility(e);
        e.clear();
    }

    /**
     * Clic en un objeto tipo WebElement
     */
    public void click(WebElement e) {
        waitForVisibility(e);
        e.click();
    }

    /**
     * Envía texto a un objeto tipo WebElement
     *
     * @param e   Objeto
     * @param txt Texto
     */
    public void sendKeys(WebElement e, String txt) {
        waitForVisibility(e);
        e.sendKeys(txt);
    }

    /**
     * Devuelve el atributo pasado como parámetro
     * de un objeto tipo WebElement
     */
    public String getAttribute(WebElement e, String attribute) {
        waitForVisibility(e);
        return e.getAttribute(attribute);
    }

    /**
     * Obtiene el texto de un objeto tipo WebElement
     * y envía un mensaje al log del framework
     */
    public String getText(WebElement e, String msg) {
        String txt = e.getText();
        return txt;
    }


    /**
     * Regresa a la página anterior visitada
     */
    public void goBackURL(){
        driver.navigate().back();
    }
}