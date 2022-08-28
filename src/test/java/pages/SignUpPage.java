package pages;

import io.qameta.allure.Step;
import models.RegistrationModel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends BaseFactoryPage {

    private static final Logger LOGGER = LogManager.getLogger(SignUpPage.class.getName());

    @FindBy(css = "[value=Register]")
    private WebElement registerButton;

    @FindBy(name = "first_name")
    private WebElement firstNameInput;

    @FindBy(name = "last_name")
    private WebElement lastNameInput;

    @FindBy(name = "email")
    private WebElement emailInput;

    @FindBy(name = "password1")
    private WebElement passwordInput;

    @FindBy(name = "password2")
    private WebElement confirmPasswordInput;

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    @Step("Check if 'Register' button is displayed")
    public boolean isRegisterDisplayed() {
        LOGGER.debug(String.format("Attempt to find Register button: %s", registerButton));
        return registerButton.isDisplayed();
    }

    @Step("Perform Registration")
    public void sendRegistrationForm(RegistrationModel registrationModel) {
        firstNameInput.sendKeys(registrationModel.getFirstName());
        lastNameInput.sendKeys(registrationModel.getLastName());
        emailInput.sendKeys(registrationModel.getEmail());
        passwordInput.sendKeys(registrationModel.getPassword());
        confirmPasswordInput.sendKeys(registrationModel.getConfirmPassword());
        registerButton.click();
    }
}
