import com.google.common.collect.Iterables;
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
public class SuccesfulLogin {
  public WebDriver driver;

  @Before
  public void setUp() {
    System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
    driver = new ChromeDriver();
  }
  @Ignore
  @Test //Basic Auth
  public void preLoginTest() {
    driver.get("https://10:10@hotelfm.ru/kazan/");
    Assert.assertEquals("Квартиры посуточно в Казани без посредников. Снять квартиру на сутки недорого. Аренда на Sdaminfo.ru", driver.getTitle());
  }

  @Ignore
  @Test //Seccessful login
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
  @Ignore
  @Test // Count 50 items in page
  public void appartmentCountInPage() {
    driver.get("https://10:10@hotelfm.ru/kazan/");
    List<WebElement> list = driver.findElements(By.cssSelector(".b-rflat"));
    Assert.assertThat(50, equalTo(list.size()));
  }

  @Test //Presence of picture
  public void presenceOfPicture() {
    driver.get("https://10:10@hotelfm.ru/kazan/");
    //List<WebElement> list = driver.findElements(By.className("b-rflat-image"));
    Pattern pattern = Pattern.compile("jpg$");
    ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
    List<WebElement> list = driver.findElements(By.className("b-rflat-image"));
    WebElement lastElement = Iterables.getLast(list, driver.findElement(By.className("b-rflat-image")));
    String tmp_el = list.get(49).findElement(By.tagName("img")).getAttribute("src");


    WebDriverWait wait = new WebDriverWait(driver, 40);
    WebElement last_visible = wait.until(ExpectedConditions
            .visibilityOf(Iterables.getLast(list, driver.findElement(By.className("b-rflat-image")))));
    for (int i=0; i<list.size(); i++) {
      String el = list.get(i).findElement(By.tagName("img")).getAttribute("src");
      Matcher matcher = pattern.matcher(el);
      System.out.println("counter = "+i+"; element = "+el);
      //Assert.assertTrue(matcher.find());
      Assert.assertTrue(pattern.matcher(el).find());
    }
//    for (int i=0; i<list.size(); i++) {
//      if (i <= 4) {
//        //WebElement l2 = el.findElement(By.tagName("img"));
//        String el = list.get(i).findElement(By.tagName("img")).getAttribute("src");
//        Matcher matcher = pattern.matcher(el);
//        Assert.assertTrue(matcher.find());
//      }
//      else{
//        String el = list.get(i).findElement(By.tagName("img")).getAttribute("src");
//        Matcher matcher = pattern.matcher(el);
//        Assert.assertTrue(matcher.find());
//      }
//    }

//    for (int i=0; i<list.size(); i++){
//      String el = list.get(i).findElement(By.tagName("img")).getAttribute("src");
//      System.out.println("counter = "+i+"; element = "+el);
//      //Assert.assertTrue(pattern.matcher(el).find());
//    }
  }

  @After
  public void closeConnect() throws Exception {
    driver.quit();
  }
}
