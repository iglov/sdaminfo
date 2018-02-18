import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.*;
import java.util.*;
import java.util.regex.Pattern;

import static org.hamcrest.core.IsEqual.equalTo;

@RunWith(JUnit4.class)
public class SuccesfulLogin extends LoginBase {

  //@Ignore
  @Test //Basic Auth
  public void preLoginTest() {
    preLoginPage();
    Assert.assertEquals("Квартиры посуточно в Казани без посредников. Снять квартиру на сутки недорого. Аренда на Sdaminfo.ru", driver.getTitle());
  }

 // @Ignore
  @Test //Seccessful LOGIN
  public void loginTest() {
    String login = "9172325235";
    String password = "12345";
    this.preLoginTest();
    loginPage(login, password);
    Assert.assertEquals("kazan",driver.getTitle());
  }

  //@Ignore
  @Test // Counts 36 items on page
  public void appartmentCountInPage() {
    preLoginPage();
    List<WebElement> list = driver.findElements(By.cssSelector(".b-rflat"));
    Assert.assertThat(36, equalTo(list.size()));
  }

  @Ignore
  @Test //Presence of picture
  public void presenceOfPicture() {
    preLoginPage();
    //List<WebElement> list = driver.findElements(By.className("b-rflat-image"));
    Pattern pattern = Pattern.compile("jpg$");
    ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
    List<WebElement> list = driver.findElements(By.className("b-rflat-image"));
    /*for (int i=0; i<list.size(); i++) {
      String el = list.get(i).findElement(By.tagName("img")).getAttribute("src");
      WebElement el1 = driver.findElement(By.tagName("img"));
      Matcher matcher = pattern.matcher(el);
      System.out.println("counter = "+i+"; element = "+el);
//      //Assert.assertTrue(matcher.find());
      Assert.assertTrue(pattern.matcher(el).find());
    }*/



    //WebElement lastElement = Iterables.getLast(list, driver.findElement(By.className("b-rflat-image")));
    //String tmp_el = list.get(49).findElement(By.tagName("img")).getAttribute("src");


//    WebDriverWait wait = new WebDriverWait(driver, 40);
//    WebElement last_visible = wait.until(ExpectedConditions
//            .visibilityOf(Iterables.getLast(list, driver.findElement(By.className("b-rflat-image")))));
//    for (int i=0; i<list.size(); i++) {
//      String el = list.get(i).findElement(By.tagName("img")).getAttribute("src");
//      Matcher matcher = pattern.matcher(el);
//      System.out.println("counter = "+i+"; element = "+el);
//      //Assert.assertTrue(matcher.find());
//      Assert.assertTrue(pattern.matcher(el).find());
//    }
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

}
