import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.Parameterized;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class AddAdvert extends LoginBase {
  String login  = "9172325235";
  String password = "12345";
  private String typeaccomodation;
  private String address;

  By addNewAdd = By.xpath("//div/a[contains(text(), 'Добавить объявление')]");
  By chooseTypeAccomodation = By.name("Flat[spo_type]");
  By chooseAddress = By.name("Flat[address]");

  public AddAdvert (String typeaccomodation, String address){
    this.typeaccomodation = typeaccomodation;
    this.address = address;
  }

  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    Object[][] data = new Object[][]{
            {"квартира", ""},
            {"коттедж", ""},
            {"комната", ""},
            {"хостел", ""},
            {"гостиница", ""}
    };
    return Arrays.asList(data);
  }

  @Test


  public void addAdvert() {
    preLoginPage();
    loginPage(login, password);
    driver.findElement(addNewAdd).click();
    Select select = new Select(driver.findElement(chooseTypeAccomodation));
    select.selectByVisibleText(typeaccomodation);
    driver.findElement(chooseAddress).sendKeys(address);

  }

}
