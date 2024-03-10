package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ByChained;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import static factories.DriverFactory.getWebDriverWait;

public class HelpDeskPage extends BasePage{

    private HelpDeskPage(){
    }

    public static HelpDeskPage getHelpDeskPage(){
        return new HelpDeskPage();
    }

    //region By definitions

    private By DEPT = By.id("helpdesk_ticket_custom_field_cf_group_selected_by_requestor_1802475");
    private By EMAIL = By.id("helpdesk_ticket_email");
    private By SUBJECT = By.id("helpdesk_ticket_subject");
    private By EDITOR = By.className("redactor_editor");
    private By SUBMIT = By.id("helpdesk_ticket_submit");
    private By REQUESTER = By.cssSelector("input[name='helpdesk_ticket[name]']");
    private By CAPTCHA_ERROR = By.id("error");

    //endregion

    public HelpDeskPage select_Department(String deptName){
        new Select(getWebDriverWait(5).until(ExpectedConditions.elementToBeClickable(DEPT))).selectByVisibleText(deptName);
        return this;
    }

    public HelpDeskPage enter_Email(String email){
        driver.findElement(EMAIL).sendKeys(email + Keys.TAB);
        return this;
    }

    public HelpDeskPage enter_Subject(String subject){
        driver.findElement(SUBJECT).sendKeys(subject);
        return this;
    }

    public HelpDeskPage enter_RequesterName(String name){
        driver.findElement(REQUESTER).sendKeys(name);
        return this;
    }

    public HelpDeskPage enter_Description(String text){
        WebElement editor = driver.findElement(EDITOR);
        scrollIntoView(editor);
        editor.click();
        editor.sendKeys(text);
        return this;
    }

    public HelpDeskPage click_Submit(){
        driver.findElement(SUBMIT).click();
        return this;
    }

    public String  get_Captcha_Error(){
        return getWebDriverWait(5).until(ExpectedConditions.visibilityOfElementLocated(CAPTCHA_ERROR)).getText();
    }
}
