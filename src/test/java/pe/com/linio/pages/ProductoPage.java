package pe.com.linio.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.WebDriverDOM;

public class ProductoPage extends WebDriverDOM {
    @FindBy(id = "buy-now")
    private WebElement btnAgregaItem;

    @FindBy(xpath = "//button[text()='Seguir comprando']")
    private WebElement btnSeguirComprando;

    @FindBy(xpath = "//h1/span[@itemprop='name']")
    private WebElement nombreProducto;

    // Métodos
    public void agregarProducto() throws InterruptedException {
        click(btnAgregaItem);
        click(btnSeguirComprando);
        System.out.println("Producto agregado: " + nombreProducto.getText());
    }
}
