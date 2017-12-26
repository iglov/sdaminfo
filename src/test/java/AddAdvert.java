import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.Parameterized;
import org.junit.runners.Suite;
import org.openqa.selenium.*;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.hamcrest.core.IsEqual.equalTo;

@RunWith(JUnit4.class)
public class AddAdvert {
  public WebDriver driver;

  @Before
  public void setUp() {
    System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
    driver = new ChromeDriver();
  }

  @Test
  public void addAdvert() {
    driver.get("https://10:10@hotelfm.ru/kazan/");
    driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/a[1]")).click();
    WebDriverWait wait = new WebDriverWait(driver, 40);
    String handle = driver.getWindowHandle();
    driver.switchTo().window(handle);
    WebElement mylogin = wait.until(ExpectedConditions
            .elementToBeClickable(By.id("AuthService_username_top")));
    mylogin.clear();
    mylogin.sendKeys("9172325235");
    WebElement mypassword = wait.until(ExpectedConditions
            .elementToBeClickable(By.id("AuthService_password")));
    mypassword.sendKeys("12345");
    driver.findElement(By.id("log_button_top")).click();

  }

  @After
  public void closeConnect() throws Exception {
    driver.quit();
  }
  }
