package pe.com.linio.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.WebDriverDOM;

public class HomePage extends WebDriverDOM {
    @FindBy(xpath = "//div[@class='input-group']/input[@name='q']")
    private WebElement qInput;

    @FindBy(css = ".btn-search")
    private WebElement btnButton;

    public void digitaSearchWord(String searchWord) {
        clear(qInput);
        sendKeys(qInput, searchWord);
    }

    public void clickSearch() {
        click(btnButton);
    }
}