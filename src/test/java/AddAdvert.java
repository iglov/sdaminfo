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
import java.util.List;

@RunWith(Parameterized.class)
public class
AddAdvert extends LoginBase {
    String login = "9172325235";
    String password = "12345";
    String price = "1000";
    String checkin = "13";
    String checkout = "12";
    String flat_floor = "5";
    String flat_floor_total = "12";
    private String typeaccomodation;
    private String address;
    private String people_number;
    private String house_type;


    By addNewAdd = By.xpath("//div/a[contains(text(), 'Добавить объявление')]");
    By chooseTypeAccomodation = By.name("Flat[spo_type]");
    By chooseAddress = By.name("Flat[address]");
    By dayliPrice = By.name("Flat[price_day]");
    By peopleIncluded = By.id("Flat_people_included");
    By checkin_time = By.id("Flat_checkin_time");
    By checkout_time = By.id("Flat_checkout_time");
    By checkboxlist = By.xpath("//div[@class='span7 offset2']");
    By flat_floor_link = By.id("Flat_floor");
    By flat_floor_total_link = By.id("Flat_floors_total");
    By button_click = By.xpath("//div[@class='btn-group js-toggle-buttons']");
    By checkboxlist1 = By.xpath("//div[@class='span3 offset2' and @class='span3']");


    public AddAdvert(String typeaccomodation, String address, String people_number, String house_type ) {
        this.typeaccomodation = typeaccomodation;
        this.address = address;
        this.people_number = people_number;
        this.house_type = house_type;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][]{
                {"квартира", "Киевская, 44", "1", "кирпичный"},
                {"коттедж", "Гвардейская, 52", "3", "монолитный"},
                {"комната", "Кирпичная, 5", "5", "панельный"},
                {"хостел", "Достоевского, 81", "7", "кирпичный"},
                {"гостиница", "Подлужная, 67", "9", "монолитный"}
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
        List<WebElement> checkBoxList=driver.findElements(checkboxlist);
        for(WebElement checkBox:checkBoxList) {
            checkBox.click();
        }
        driver.findElement(flat_floor_link).sendKeys(flat_floor);
        driver.findElement(flat_floor_total_link).sendKeys(flat_floor_total);
        String str1 = "[value=";
        String str2 = house_type;
        String str3 = "]";
        String str = str1+str2+str3;
        driver.findElement(button_click).findElement(By.cssSelector(str)).click();
        List<WebElement> checkBoxList1=driver.findElements(checkboxlist1);
        for(WebElement checkBox:checkBoxList1) {
            checkBox.click();
        }


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


