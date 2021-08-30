import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TVTest {

    public static MainPage mainPage;
    public static TvPage tvPage;
    public static WebDriver driver;

    @BeforeAll
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        tvPage = new TvPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://onliner.by");
    }

    @Test
    public void testUnClickSamsungTv() {

        mainPage.clickTvButton();
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0,300)");
        tvPage.clickSamsungButton();
        Assertions.assertFalse(tvPage.getSamsungSelect().isSelected());
    }

    @Test
    public void testChooseXiaomiTv() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0,300)");
        tvPage.clickXiaomiButton();
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0,4300)" );
        Assertions.assertFalse(tvPage.getItemName("Xiaomi"));
    }
        @AfterAll
        public static void tearDown() {
            driver.quit();
    }
}







