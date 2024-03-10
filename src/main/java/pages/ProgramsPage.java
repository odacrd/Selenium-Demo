package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import static factories.DriverFactory.getWebDriverWait;

import static factories.DriverFactory.getWebDriverWait;
public class ProgramsPage extends BasePage{

    WebDriverWait wait;

    private ProgramsPage(){
    }
    public static ProgramsPage getProgramsPage(){
        return new ProgramsPage();
    }

    private WebElement container = driver.findElement(By.id("partner-program-type-container"));
    private By forCoBranded = (By.id("cobranded-program-btn-field"));

    public ProgramsPage click_CoBrandProgramBtn(){
        // wait for the container element on the 'Your account information' page and click on the 'Co-branded' option
        WebElement partnerPgmContainer =  getWebDriverWait(10).until(ExpectedConditions.visibilityOf(container));
        partnerPgmContainer.findElement(forCoBranded).click();
        return this;

    }

}
