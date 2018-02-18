import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class LoginBase {
  public WebDriver driver;

  protected void preLoginPage() {
    driver.get("http://10:10@hotelfm.ru/kazan/");
  }

  protected void loginPage(String login, String pass) {
    driver.findElement(By.xpath("//span[contains(text(), 'Войти')]")).click();
    WebDriverWait wait = new WebDriverWait(driver, 40);
    String handle = driver.getWindowHandle();
    driver.switchTo().window(handle);
    WebElement mylogin = wait.until(ExpectedConditions
            .elementToBeClickable(By.id("AuthService_username_top")));
    mylogin.clear();
    mylogin.sendKeys(login);

    WebElement mypassword = wait.until(ExpectedConditions
            .elementToBeClickable(By.id("AuthService_password")));
    mypassword.sendKeys(pass);
    driver.findElement(By.id("log_button_top")).click();
  }

  @Before
  public void setUp() {
//    System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
    System.setProperty("webdriver.chrome.driver", "/webdrivers/chromedriver");
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
  }

  @After
  public void closeConnect() throws Exception {
    driver.quit();
  }
}
