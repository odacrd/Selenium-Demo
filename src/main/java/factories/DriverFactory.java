package factories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

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
        //ChromeOptions options = new ChromeOptions().addArguments("start-fullscreen");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("chrome.switches", "--disable-extensions --disable-extensions-file-access-check --disable-extensions-http-throttling --disable-infobars --enable-automation --start-maximized");

        HashMap<String, Object> chromeOptionsMap = new HashMap<String, Object>();
        chromeOptionsMap.put("credentials_enable_service", false);
        chromeOptionsMap.put("password_manager_enabled", false);
        chromeOptionsMap.put("autofill.profile_enabled", false);
        options.setExperimentalOption("prefs", chromeOptionsMap);





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