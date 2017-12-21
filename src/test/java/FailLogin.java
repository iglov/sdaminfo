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
    private String expected_errormessage;
    private String warning_locator;
    private static int counter;
    private static int mainCounter;
    private static int beforeCounter;

  public FailLogin(String login, String password, String expected_errormessage, String warning_locator) {
    this.login = login;
    this.password = password;
    this.expected_errormessage = expected_errormessage;
    this.warning_locator = warning_locator;
  }

  @Before
  public void setUp() {
    System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
    driver = new ChromeDriver();
  }

  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    Object[][] data = new Object[][]{
            {"9172664845", "012345", "К сожалению, такой пользователь или пароль не найден.", "//*[@id=\"yw0\"]/div[2]/span"},
            {"9172664845", "", "Необходимо заполнить поле «Пароль».", "//*[@id=\"yw0\"]/span"},
            {"", "12345", "Необходимо заполнить поле «Телефон».", "//*[@id=\"yw0\"]/div[2]/span"}
    };
    return Arrays.asList(data);
  }

  @Test  //Fail login parametrized
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
    Assert.assertEquals("Проверка правильного логина и пустого пароля не прошла",expected_errormessage, driver
            .findElement(By.xpath(warning_locator)).getText());
  }

  @After
  public void closeConnect() throws Exception {
    driver.quit();
  }

}
