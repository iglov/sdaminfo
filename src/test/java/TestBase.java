import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;

import javax.security.auth.login.Configuration;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class TestBase {
    public WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void preLoginTest() {
        driver.get("https://hotelfm.ru/kazan/");
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("10");
        alert.sendKeys("10");
        alert.accept();
    }

    @After
    public void driverQuit() {
        driver.quit();
    }
}
