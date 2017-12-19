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

@RunWith(Parameterized.class)
public class FailLogin {
    public WebDriver driver;
    private String login;
    private String password;
    private static int counter;
    private static int mainCounter;
    private static int beforeCounter;

  public FailLogin(String login, String password) {
    this.login = login;
    this.password = password;
    System.out.println("constructor = " + mainCounter++);
  }

  @Before
  public void setUp() {
    System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
    driver = new ChromeDriver();
    System.out.println("before = " + beforeCounter++);
  }

  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    Object[][] data = new Object[][]{
            {"9172664845", "00012345"},
            {"user2", "12345"},
            {"user3", "логин не может быть пустым"}
    };
    return Arrays.asList(data);
  }

  @Test
  public void failLoginTest() {
    driver.get("https://10:10@hotelfm.ru/kazan/");
    driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/a[1]")).click();
    WebDriverWait wait = new WebDriverWait(driver, 10);
    String handle = driver.getWindowHandle();
    driver.switchTo().window(handle);
    WebElement mylogin = wait.until(ExpectedConditions
            .elementToBeClickable(By.id("AuthService_username_top")));
    mylogin.clear();
    mylogin.sendKeys(login);

    WebElement mypassword = wait.until(ExpectedConditions
            .elementToBeClickable(By.id("AuthService_password")));
    mypassword.sendKeys(password);

    driver.findElement(By.id("log_button_top")).click();
    Assert.assertFalse("qwer",false);

    System.out.println("Inside test! = "+counter++);
    System.out.println("login = "+login);
    System.out.println("password = "+password);

  }

  @After
  public void closeConnect() throws Exception {
    driver.quit();
  }

}
