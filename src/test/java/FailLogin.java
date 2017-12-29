import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.*;

@RunWith(Parameterized.class)
public class FailLogin extends LoginBase {
  private String login;
  private String password;
  private String expected_errormessage;
  private String warning_locator;

  public FailLogin(String login, String password, String expected_errormessage, String warning_locator) {
    this.login = login;
    this.password = password;
    this.expected_errormessage = expected_errormessage;
    this.warning_locator = warning_locator;
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

  @Test  //Fail LOGIN parametrized
  public void failLoginTest() {
    preLoginPage();
    loginPage(login, password);
    Assert.assertEquals("Проверка правильного логина и пустого пароля не прошла", expected_errormessage, driver
            .findElement(By.xpath(warning_locator)).getText());
  }

}
