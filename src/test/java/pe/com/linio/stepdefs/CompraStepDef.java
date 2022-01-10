package pe.com.linio.stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pe.com.linio.pages.HomePage;
import pe.com.linio.pages.ProductoPage;
import pe.com.linio.pages.ResultsPage;

public class CompraStepDef {
    HomePage homePage = new HomePage();
    ResultsPage resultsPage = new ResultsPage();
    ProductoPage productoPage = new ProductoPage();

    @Given("Digito la palabra {string}")
    public void digitoLaPalabra(String searchWord) {
        homePage.digitaSearchWord(searchWord);
    }

    @When("Hago clic en boton de busqueda")
    public void hagoClicEnBotonDeBusqueda() {
        homePage.clickSearch();
    }

    @And("Filtro por la marca {string}")
    public void filtroPorLaMarca(String marca) {
        resultsPage.filtrarPorMarca(marca);
    }

    @And("Filtro por catalogo {string}")
    public void filtroPorCatalogo(String catalogo) {
        resultsPage.filtrarPorCatalogo(catalogo);
    }

    @And("Ordeno el listado por {string}")
    public void ordenoElListadoPor(String ordenamiento) {
        resultsPage.ordenarResultados(ordenamiento);
    }

    @Then("Imprimo el número de resultados")
    public void imprimoElNumeroDeResultados() {
        System.out.println("ÍTEMS ENCONTRADOS: " + resultsPage.getNumResultados());
    }

    @And("Ordeno e imprimo los productos por nombre ascendente")
    public void ordenoEImprimoLosProductosPorNombreAscendente() {
        System.out.println("===============================================\n" +
                "Imprimiendo resultados ordenados por nombre ascendente");
        resultsPage.imprimeListadoPorNombre();
    }

    @And("Ordeno e imprimo los productos por precio descendente")
    public void ordenoEImprimoLosProductosPorPrecioDescendente() {
        System.out.println("===============================================\n" +
                "Imprimiendo resultados ordenados por precio descendente");
        resultsPage.imprimeListadoPorPrecio();
    }

    @And("Agrego los primeros {int} productos")
    public void agregoLosPrimerosProductos(int numProd) throws InterruptedException {
        // Agrega los n primeros productos del resultado.
        for (int i = 1; i <= numProd; i++) {
            resultsPage.verProducto(i);
            productoPage.agregarProducto();
            productoPage.goBackURL();
        }
    }
}
