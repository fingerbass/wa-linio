package pe.com.linio.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.WebDriverDOM;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ResultsPage extends WebDriverDOM {
    @FindBy(xpath = "//dt[text()='Marca']")
    private WebElement filtroMarca;

    @FindBy(id = "brand-body")
    private WebElement subFiltroMarca;

    @FindBy(xpath = "//span[@class='results-quantity']")
    private WebElement numResultados;

    @FindBy(xpath = "//div[@class='catalogue-list']")
    private WebElement filtroCatalogo;

    @FindBy(xpath = "//form/span[text()='Ordenar por']")
    private WebElement filtroOrden;

    @FindBy(id = "sortBy-body")
    private WebElement listaOrdenamiento;

    @FindBy(id = "catalogue-product-container")
    private WebElement listadoProductos;

    //=========== Métodos de acción ===========
    public void filtrarPorMarca(String marca) {
        click(filtroMarca);

        // escribe la palabra a buscar en el subfiltro de la marca
        sendKeys(nestedWebElement(subFiltroMarca, "div/input"), marca);

        // activa la casilla de la marca que contenga la palabra de búsqueda.
        // Se debe colocar el nombre de la marca como figura en la web (Capitalizado)
        click(nestedWebElement(subFiltroMarca, "ul/li/label/span/a[text()='" + marca + "']"));
    }

    public void filtrarPorCatalogo(String keyword) {
        try {
            click(nestedWebElement(filtroCatalogo, "ul/li/ul/li/a[@Title='" + keyword + "']"));
        } catch (Exception e) {
            System.out.println("Filtro del catálogo no encontrado. " + e.getMessage());
        }
    }

    public String getNumResultados() {
        return numResultados.getText();
    }

    public void ordenarResultados(String tipoOrden) {
        click(filtroOrden);
        click(nestedWebElement(listaOrdenamiento, "ul/li/label/a[contains(text(),'" + tipoOrden + "')]"));
    }

    public void verProducto(int i) {
        click(nestedWebElement(listadoProductos, "div[" + i + "]/a"));
    }

    public void imprimeListadoPorNombre() {
        List<WebElement> items = listadoProductos.findElements(By.xpath("./child::*"));
        List<String> listaOrdenada = new ArrayList<>();

        for (WebElement i :
                items) {
            listaOrdenada.add(i.findElement(By.xpath("a/div/p/span")).getText());
        }

        Collections.sort(listaOrdenada);
        listaOrdenada.forEach(System.out::println);
    }

    public void imprimeListadoPorPrecio() {
        List<WebElement> items = listadoProductos.findElements(By.xpath("./child::*"));
        List<String> listaOrdenada = new ArrayList<>();

        for (WebElement i :
                items) {
            listaOrdenada.add(i.findElement(By.xpath("a/div/div/meta[@itemprop='price']")).getAttribute("content"));
        }

        listaOrdenada.sort(Collections.reverseOrder());
        listaOrdenada.forEach(System.out::println);
    }
}