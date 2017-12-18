import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
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

//@RunWith(JUnit4.class)
@RunWith(DataProviderRunner.class)
public class TestBase {
    public WebDriver driver;



    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void preLoginTest() {
        driver.get("https://10:10@hotelfm.ru/kazan/");
        Assert.assertEquals("Квартиры посуточно в Казани без посредников. Снять квартиру на сутки недорого. Аренда на Sdaminfo.ru",driver.getTitle());
    }

    @Test
    public void loginTest() {
        driver.get("https://10:10@hotelfm.ru/kazan/");
        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/a[1]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        String handle = driver.getWindowHandle();
        driver.switchTo().window(handle);
        WebElement mylogin = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//*[@id=\"AuthService_username_top\"]")));
        mylogin.sendKeys("9172664845");
        WebElement mypassword = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//*[@id=\"AuthService_username_top\"]")));
        mypassword.sendKeys("12345");
        driver.findElement(By.xpath("//*[@id=\"AuthService_password\"]"))
                .sendKeys("12345");
        driver.findElement(By.xpath("//*[@id=\"log_button_top\"]")).click();
        WebElement mytitle = wait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("/html/head/title")));
        Assert.assertEquals("kazan",driver.getTitle());
    }

    @DataProvider
    public Object[][] provideData() {

        return new Object[][] {
                { "angeleclipse3@gmail.com", "angele_clip_3" },
                { "Angel", "angele_clip_3" },
                { "Angel", "testpass" },
                { "", "testpass" },
                { "angeleclipse3@gmail.com", "" },
                { "angeleclipse3@gmail.com", "“[|]’~<!--@/*$%^&#*/()?>,.*/\\" },
                { "angeleclipse3@gmail.com",
                        "asafsfsddddddddddddddddddddkkkkkkkkkkkkkkkkkkkkkkkkkkkkkeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee3333333333333333344444444444" },
                { "angeleclipse3@gmail.com",
                        "testpassssssssssssssssssssssssSSSSSSSSSSSSSSSSSSSSSSSsssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss" },
                { "angeleclipse3@gmail.com", "s" },
                { "angeleclipse3@gmail.com", "пароль" },
                { "angeleclipse3@gmail.com", "null" },
                { "angeleclipse3@gmail.com", "12312" },
                { "testpass", "angeleclipse3@gmail.com" },
                { "DROP TABLE user;", "testpass" } //Depends on DB

        };
    }

    @Test
    @UseDataProvider("provideData")
    public void failLoginTest() {


    }

    @After
    public void closeConnect() throws Exception {
        driver.quit();
    }
}
