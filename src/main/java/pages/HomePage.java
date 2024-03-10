package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ByChained;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static factories.DriverFactory.getWebDriverWait;

public class HomePage extends BasePage {
    public static final String HOME = "https://www.sherweb.com/";
    private HomePage(){
    }
    private HomePage(WebDriver driver){
        this.driver = driver;
    }
    public static HomePage getHomePage(){
        driver.get(HOME);
        return new HomePage(driver);
    }

    //region By definitions
    private By START_HERE = By.xpath("//a[text()='Start here']");
    private By PAGE_H1 = (By.tagName("h1"));
    private ByChained TABS_PATH = new ByChained(By.id("menu-mainv3-1"),By.tagName("li"));
    private ByChained REQUEST_PATH = new ByChained(By.id("helpdesk-element"),By.cssSelector("div[class='row p-4']"),
            By.cssSelector("a[href*='support/tickets']"));

    //endregion


    public HomePage click_MenuTab(String tabName)throws InterruptedException{
        WebElement tab = driver.findElements(TABS_PATH).stream()
                .filter(item -> item.findElement(By.tagName("span")).getText().contentEquals(tabName))
                .findAny()
                .orElse(null);
        tab.click();
        //Thread.sleep(2000);
        //WebElement zz = getWebDriverWait(5).until(ExpectedConditions.elementToBeClickable(supportRequestPath));

        //tab.click();
        //Thread.sleep(2000);
        return this;
    }
    public HomePage click_Accept_Cookies(){
        try{
            getWebDriverWait(10).until(ExpectedConditions.elementToBeClickable(acceptBtn)).click();
        } catch(Exception e)
        {}
        return this;
    }
    public HomePage click_Support_Request(){
        getWebDriverWait(5).until(ExpectedConditions.elementToBeClickable(REQUEST_PATH)).click();
        return this;
    }
    public HomePage click_startHereBtn(){
        driver.findElement(START_HERE).click();
        return this;
    }
    public String get_PageH1ActualText(){
        return getWebDriverWait(10).until(ExpectedConditions.visibilityOfElementLocated(PAGE_H1)).getText();
    }
    public String get_PageH1ExpectedText(){
        return "Looking for more than a cloud marketplace?\nYou’ve come to\nthe right place";
    }


}
