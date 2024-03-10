package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Set;

import static factories.DriverFactory.getFactoryDriver;
import static factories.DriverFactory.getWebDriverWait;

public class BasePage {

    public static WebDriver driver = getFactoryDriver();

    protected BasePage(){

    }

    protected By acceptBtn = By.id("onetrust-accept-btn-handler");

    public void scrollIntoView(WebElement element){

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
