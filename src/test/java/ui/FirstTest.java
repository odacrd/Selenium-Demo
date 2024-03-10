package ui;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import pages.AccountInfoPage;
import pages.HelpDeskPage;
import pages.HomePage;
import pages.ProgramsPage;

import java.time.Duration;

import static factories.DriverFactory.getWebDriverWait;

public class FirstTest extends BaseTest{

    HomePage homePage;
    private WebDriverWait wait;
    ProgramsPage programsPage;
    AccountInfoPage accountInfoPage;
    HelpDeskPage helpDeskPage;


    @Test
    public void testSelectProgram() throws InterruptedException {

        homePage = HomePage.getHomePage();
        Assert.assertEquals(homePage.get_PageH1ExpectedText(),homePage.get_PageH1ActualText()); // verify the Home page h1 text

        String currentPageHandle = getCurrentWindowHandle(); // save the handle for the current window

        homePage.click_Accept_Cookies()  // wait for the 'Accept cookies' and click it
            .click_startHereBtn(); // check there's only 1 window and get its handle

        // there should now be the 'Choose the partner program' page launched in new tab
        goToNewTabFrom(currentPageHandle);

        // wait for and click the 'Co-branded' 'Select' button
        programsPage = ProgramsPage.getProgramsPage()
                .click_CoBrandProgramBtn();

        // when Account Info page loads, fill in the form
        accountInfoPage = AccountInfoPage.getAccountInfoPage()
                .enter_businessEmail("tester@test.ca")
                .enter_firstName("MyFirstName")
                .enter_lastName("MyLastName")
                .enter_phoneNumber("4164567890")
                .enter_companyName("Danco Products")
                .enter_StreetAddress("2984 Drew Drive")
                .enter_City("South Mountain")
                .select_Country("Canada")
                .select_Province("Ontario")
                .enter_PostalCode("k0e 1w0")
                .click_Continue();

        Assert.assertEquals(accountInfoPage.get_PasswordHintText(), accountInfoPage.get_ExpectedHintText());
        Thread.sleep(5000);


    }


    @Test
    public void testSubmitRequest() throws InterruptedException {

        homePage = HomePage.getHomePage();
        Assert.assertEquals(homePage.get_PageH1ExpectedText(),homePage.get_PageH1ActualText()); // verify the Home page h1 text

        String currentPageHandle = getCurrentWindowHandle(); // save the handle for the current window

        homePage.click_Accept_Cookies()  // wait for the 'Accept cookies' and click it
                .click_MenuTab("Helpdesk") // click the Help Desk tab
                .click_Support_Request(); // open the support request form

        helpDeskPage = HelpDeskPage.getHelpDeskPage()
                .select_Department("Support")
                .enter_Email("tester@test.ca")
                .enter_RequesterName("John Smith")
                .enter_Subject("Can't login")
                .enter_Description("It worked yesterday")
                .click_Submit();
        Assert.assertTrue(helpDeskPage.get_Captcha_Error().contains("Captcha verification failed, try again!"));

        Thread.sleep(5000);

    }
}
