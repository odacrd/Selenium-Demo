package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import static factories.DriverFactory.getWebDriverWait;
public class AccountInfoPage extends BasePage{

    WebDriverWait wait;
    private AccountInfoPage(){
    }

    public static AccountInfoPage getAccountInfoPage(){
        return new AccountInfoPage();
    }

    //region By definitions
    private By COMPANY = By.id("company_name");
    private By PHONE = By.id("phone_number");
    private By FIRSTNAME = By.id("first_name");
    private By LASTNAME = By.id("last_name");
    private By EMAIL = By.id("email");
    private By STREET = By.id("address");
    private By CITY = By.id("city");
    private By COUNTRY = By.id("country");
    private By PROV = By.id("state");
    private By ZIP = By.id("zip");
    private By CONTINUE = By.cssSelector("div[class='button button-orange button__full carousel-control-next next-button']");
    private By PWDHINT = By.id("password-hint");

    //endregion

    public AccountInfoPage enter_businessEmail(String email){
        getWebDriverWait(10).until(ExpectedConditions.elementToBeClickable(EMAIL)).sendKeys(email);
        return this;
    }
    public AccountInfoPage enter_firstName(String firstname){
        driver.findElement(FIRSTNAME).sendKeys(firstname);
        return this;
    }
    public AccountInfoPage enter_lastName(String lastname){
        driver.findElement(LASTNAME).sendKeys(lastname);
        return this;
    }
    public AccountInfoPage enter_phoneNumber(String phone){
        driver.findElement(PHONE).sendKeys(phone);
        return this;
    }
    public AccountInfoPage enter_companyName(String name){
        driver.findElement(COMPANY).sendKeys(name);
        return this;
    }
    public AccountInfoPage enter_StreetAddress(String street){
        driver.findElement(STREET).sendKeys(street);
        return this;
    }
    public AccountInfoPage enter_City(String name){
        driver.findElement(CITY).sendKeys(name);
        return this;
    }
    public AccountInfoPage select_Country(String name) {
        new Select(driver.findElement(COUNTRY)).selectByVisibleText(name);
        return this;
    }
    public AccountInfoPage select_Province(String name) {
        new Select(driver.findElement(PROV)).selectByVisibleText(name);
        return this;
    }
    public AccountInfoPage enter_PostalCode(String postalCode){
        driver.findElement(ZIP).sendKeys(postalCode);
        return this;
    }
    public AccountInfoPage click_Continue(){
        driver.findElement(CONTINUE).click();
        return this;
    }
    public String get_PasswordHintText() {
        return getWebDriverWait(10).until(ExpectedConditions.visibilityOfElementLocated(PWDHINT)).getText();
    }
    public String get_ExpectedHintText() {
        return "Your password must contain at least 7 characters and include the following: lowercase letters, uppercase letters, numbers and special characters.";
    }

}
