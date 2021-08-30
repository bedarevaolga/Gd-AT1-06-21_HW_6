import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    @FindBy(xpath = "//span[@class=\"project-navigation__sign\" and contains(text(),'Телевизоры')]")
    private WebElement Tv_Button;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickTvButton() {
        Tv_Button.click();
    }
}
