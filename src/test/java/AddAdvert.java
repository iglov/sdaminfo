import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.Parameterized;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class AddAdvert extends LoginBase {
    String login = "9172325235";
    String password = "12345";
    String price = "1000";
    String checkin = "13";
    String checkout = "12";
    private String typeaccomodation;
    private String address;
    private String people_number;
    private String rooms_number;


    By addNewAdd = By.xpath("//div/a[contains(text(), 'Добавить объявление')]");
    By chooseTypeAccomodation = By.name("Flat[spo_type]");
    By chooseAddress = By.name("Flat[address]");
    By dayliPrice = By.name("Flat[price_day]");
    By peopleIncluded = By.id("Flat_people_included");
    By checkin_time = By.id("Flat_checkin_time");
    By checkout_time = By.id("Flat_checkout_time");
    By flat_rooms = By.xpath("//button[@class='btn button-silver' and @value='"+ rooms_number +"']");
    //By flat_rooms = By.xpath("//button[@class='btn button-silver' and @value='2']");
    By registration = By.id("submit_button");


    public AddAdvert(String typeaccomodation, String address, String people_number, String rooms_number ) {
        this.typeaccomodation = typeaccomodation;
        this.address = address;
        this.people_number = people_number;
        this.rooms_number = rooms_number;
    }

    @Parameterized.Parameters(name = "typeaccomodation= {0} address= {1} people_number= {2} rooms_number = {3}")
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][]{
                {"квартира", "Киевская, 44", "1", "1"},
                {"коттедж", "Гвардейская, 52", "3", "2"},
                {"комната", "Кирпичная, 5", "5", "3"},
                {"хостел", "Достоевского, 81", "7", "4"},
                {"гостиница", "Подлужная, 67", "9", "1"}
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
        driver.findElement(dayliPrice).sendKeys(price);
        Select select1 = new Select(driver.findElement(peopleIncluded));
        select1.selectByVisibleText(people_number);
        driver.findElement(checkin_time).sendKeys(checkin);
        driver.findElement(checkout_time).sendKeys(checkout);
        driver.findElement(flat_rooms).click();
        driver.findElement(registration).click();




        /*WebDriverWait wait = new WebDriverWait(driver, 10);
        *//*WebElement triggerDropDown = driver.findElement(choose_days_rent);
        triggerDropDown.click();*//*
        driver.findElement(discountLink).click();
        *//*WebElement selectElement = wait.until(ExpectedConditions.visibilityOfElementLocated(choose_days_rent));*//*
        WebElement elem = driver.findElement(choose_days_rent);
        Select select1 = new Select(elem);
        select1.selectByVisibleText(days_rent);
        if (driver.findElement(choose_days_rent).isDisplayed()) {
            System.out.println("Element is Visible");
        } else {
            System.out.println("Element is InVisible");
        }*/

    }


}


