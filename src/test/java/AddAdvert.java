import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.*;

@RunWith(JUnit4.class)
public class AddAdvert extends LoginBase {
  String login = "9172325235";
  String password = "12345";
  By addNewAdd = By.xpath("//*[contains(@class,'Добавить объявление')]");


  @Test
  public void addAdvert() {
    preLoginPage();
    loginPage(login, password);
    driver.findElement(addNewAdd).click();

  }

}
