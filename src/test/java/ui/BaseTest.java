package ui;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Set;

import static factories.DriverFactory.*;


public class BaseTest {

    protected WebDriver driver;
    protected WebDriver getDriver(){
        //driver = getFactoryDriver();
        return driver;
    }


    @BeforeEach
    void setup(){
        driver = getFactoryDriver();

    }


    @AfterEach
    void cleanUp(){
        //driver.close();
        driver.quit();
    }

    public Integer getNumberOfWindows(){
        return driver.getWindowHandles().size();
    }

    public String getCurrentWindowHandle(){
        String originalWindow = driver.getWindowHandle();
        return originalWindow;
    }

    public Set<String> getAllWindowHandles(){
        Set<String> handles = driver.getWindowHandles();
        return handles;
    }

    public void goToNewTabFrom(String originalHandle){
        // wait for the new window handle
        getWebDriverWait(10).until(ExpectedConditions.numberOfWindowsToBe(2));

        //Loop through until we find a new window handle and switch the driver to it
        for (String handle : getAllWindowHandles()) {
            if(!originalHandle.contentEquals(handle)) {
                driver.switchTo().window(handle);
                break;
            }
        }
    }

}
