package factories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DriverFactory {
    private static WebDriverWait wait;
    private static WebDriver driver;

    public static WebDriver getFactoryDriver(){
        if(driver==null) {
            driver = newChromeDriver();
        }
        return driver;
    }
    private static WebDriver applyCommonSetup(WebDriver driver){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return driver;
    }
    private static WebDriver newChromeDriver(){
        ChromeOptions options = new ChromeOptions().addArguments("start-fullscreen");
        driver = applyCommonSetup(new ChromeDriver(options));
        return driver;
    }
    public static WebDriverWait getWebDriverWait(long lSeconds){
        if(wait==null){
            wait = new WebDriverWait(getFactoryDriver(),Duration.ofSeconds(lSeconds));
        }
        return wait;
    }
}