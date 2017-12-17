import org.junit.*;
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
        driver.get("https://10:10@hotelfm.ru/kazan/");
        Assert.assertEquals("Квартиры посуточно в Казани без посредников. Снять квартиру на сутки недорого. Аренда на Sdaminfo.ru",driver.getTitle());
    }

    @Test
    public void loginTest() {
        driver.get("https://hotelfm.ru/kazan/");
        driver.findElement(By.name("Войти")).click();

    }

    @After
    public void closeConnect() throws Exception {
        driver.quit();
    }
}
