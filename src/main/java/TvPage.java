import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TvPage {

    private WebDriver driver;
    @FindBy(xpath = "//ul[@class='schema-filter__list']//span[text()='Samsung']")
    private WebElement SamsungSelect;

    @FindBy(xpath = "//ul[@class='schema-filter__list']//span[text()='Xiaomi']")
    private WebElement XiaomiSelect;

    @FindBy(xpath = "//span[@data-bind='html: product.extended_name || product.full_name']")
    private WebElement item;

    public TvPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement getSamsungSelect() {
        return SamsungSelect;
    }

    public void clickSamsungButton() {
        SamsungSelect.click();
    }

    public void clickXiaomiButton() {
        XiaomiSelect.click();
    }

    public boolean getItemName(String name) {

        List<WebElement> items = driver.findElements(By.xpath("//span[@data-bind='html: product.extended_name || product.full_name']"));

        boolean result = false;
        int attempts = 0;
        while (attempts < 3) {
            try {
                for (WebElement item : items) {
                    if (!item.getText().contains(name)) {
                        result = true;
                        break;
                    }
                }
            } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            }
            attempts++;
        }
        return result;
    }
}

