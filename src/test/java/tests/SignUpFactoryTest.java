package tests;

import io.qameta.allure.*;
import models.RegistrationModel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountCreatedPage;
import pages.SignUpPage;
import pages.ZipcodePage;
import testdata.PrepareRegistrationData;
import utils.FakeMessageGenerator;

@Epic("User Management")
@Feature("Registration")
@Story("User Registration")
public class SignUpFactoryTest extends BaseTest {

    private static  final Logger LOGGER = LogManager.getLogger(SignUpFactoryTest.class.getName());

    @Test(priority = 2)
    @Description("User tries to input 5 digits zip code")
    @Issue("QA-125")
    @TmsLink("SHARELANE-1")
    @Severity(SeverityLevel.BLOCKER)
    public void fiveDigitZipCodeTest() {
        ZipcodePage zipcodeFactoryPage = new ZipcodePage(driverManager.getDriver());
        LOGGER.info(String.format("Page %s initialized", ZipcodePage.class.getName()));
        LOGGER.info(String.format("Open %s page", ZipcodePage.class.getName()));
        zipcodeFactoryPage.openZipcodePage();
        LOGGER.info("Input zipcode");
        zipcodeFactoryPage.inputZipCode(FakeMessageGenerator.generateFiveDigitsZipCode());
        LOGGER.info("Proceed with zipcode");
        zipcodeFactoryPage.clickContinue();
        SignUpPage signUpFormFactoryPage = new SignUpPage(driverManager.getDriver());
        LOGGER.info(String.format("Page %s initialized", SignUpPage.class.getName()));
        LOGGER.info("Check if button is displayed");
        Assert.assertTrue(signUpFormFactoryPage.isRegisterDisplayed(), "'Register' button isn't displayed");
    }

    @Test(priority = 1, description = "User performs sign up to the system")
    @Description("User performs sign up to the system")
    @Severity(SeverityLevel.BLOCKER)
    public void signUpTest() {
        ZipcodePage zipcodeFactoryPage = new ZipcodePage(driverManager.getDriver());
        zipcodeFactoryPage.openZipcodePage();
        zipcodeFactoryPage.inputZipCode(FakeMessageGenerator.generateFiveDigitsZipCode());
        zipcodeFactoryPage.clickContinue();
        SignUpPage signUpFormFactoryPage = new SignUpPage(driverManager.getDriver());
        RegistrationModel registrationModel = PrepareRegistrationData.getValidRegistration();
        signUpFormFactoryPage.sendRegistrationForm(registrationModel);
        AccountCreatedPage accountCreatedFactoryPage = new AccountCreatedPage(driverManager.getDriver());
        Assert.assertTrue(accountCreatedFactoryPage.isMessageDisplayed(), "'Account is created!' message isn't displayed");
    }
}
