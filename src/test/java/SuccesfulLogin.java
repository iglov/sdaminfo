import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.Parameterized;
import org.junit.runners.Suite;
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
//import org.slf4j.Logger;

import javax.security.auth.login.Configuration;
import java.io.File;
import java.util.*;
import java.util.concurrent.TimeUnit;

@RunWith(JUnit4.class)
public class SuccesfulLogin {
  public WebDriver driver;

  @Before
  public void setUp() {
    System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
    driver = new ChromeDriver();
  }
  @Ignore
  @Test
  public void preLoginTest() {
    driver.get("https://10:10@hotelfm.ru/kazan/");
    Assert.assertEquals("Квартиры посуточно в Казани без посредников. Снять квартиру на сутки недорого. Аренда на Sdaminfo.ru", driver.getTitle());
  }

  @Test
  public void loginTest() {
    driver.get("https://10:10@hotelfm.ru/kazan/");
    driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/a[1]")).click();
    WebDriverWait wait = new WebDriverWait(driver, 40);
    String handle = driver.getWindowHandle();
    driver.switchTo().window(handle);
    WebElement mylogin = wait.until(ExpectedConditions
            .elementToBeClickable(By.id("AuthService_username_top")));
    mylogin.clear();
    mylogin.sendKeys("9172664845");
    WebElement mypassword = wait.until(ExpectedConditions
            .elementToBeClickable(By.id("AuthService_password")));
    mypassword.sendKeys("12345");
    driver.findElement(By.id("log_button_top")).click();
    Assert.assertEquals("kazan",driver.getTitle());
  }

  @After
  public void closeConnect() throws Exception {
    driver.quit();
  }
}
