package pe.com.linio;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import mail.MailSender;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty"
                , "html:reportes/html/index.html"
                , "json:reportes/json/reporteCucumber.json"
                , "de.monochromata.cucumber.report.PrettyReports:reportes"
        }
        , features = {"src/test/java/pe/com/linio/features"}
        , glue = {"pe/com/linio/stepdefs"}
        , snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class RunTest {
    @AfterClass
    public static void sendReport() throws Exception {
        MailSender.sendReportHTML("elias.valderrama@tismart.com", "reportes/html/index.html");
    }
}
