package managers;

import java.util.Properties;

public class GlobalParams {
    private static final ThreadLocal<String> webTestURL = new ThreadLocal<>();
    private static final ThreadLocal<String> navigatorDriver = new ThreadLocal<>();

    public void setWebTestURL(String webTestURL2) {
        webTestURL.set(webTestURL2);
    }

    public void setNavigatorDriver(String navigatorDriver2) {
        navigatorDriver.set(navigatorDriver2);
    }

    public String getWebTestURL() {
        return webTestURL.get();
    }

    public String getNavigatorDriver() {
        return navigatorDriver.get();
    }

    /**
     * Lee el archivo de configuración y lo almacena en las variables:
     * webTestURL
     * navigatorDriver
     */
    public void inicializaParametrosGlobales() {
        Properties props = new PropertyManager().getProp();

        GlobalParams params = new GlobalParams();
        params.setNavigatorDriver(props.getProperty("navigatorDriver"));
        params.setWebTestURL(props.getProperty("webTestURL"));
    }


}
