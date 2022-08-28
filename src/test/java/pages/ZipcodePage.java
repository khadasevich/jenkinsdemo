package pages;

import constants.Urls;
import io.qameta.allure.Step;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * ZipcodeFactoryPage describes page with ZipCode input filed
 * contains set of methods to communicate with page (open, input zip, click continue button)
 *
 * @author Alex K
 * @version 1.0
 */
public class ZipcodePage extends BaseFactoryPage{

    private static  final Logger LOGGER = LogManager.getLogger(ZipcodePage.class.getName());

    /**
     * WebElement for input filed
     */
    @FindBy(name="zip_code")
    public WebElement zipCodeInput;

    /**
     * WebElement for continue button
     */
    @FindBy(css="[value=Continue]")
    private WebElement continueButton;

    public ZipcodePage(WebDriver driver) {
        super(driver);
    }

    /**
     * This method opens zip code page
     */
    @Step("Open Zip code page")
    public void openZipcodePage() {
        LOGGER.debug(String.format("Attempt to open URL: %s", Urls.REGISTER_FORM_URL));
        driver.get(Urls.REGISTER_FORM_URL);
    }

    /**
     * This method allows input zipcode
     * @param zipCode the text for input
     */
    @Step("Input zipcode '{zipCode}'")
    public void inputZipCode(String zipCode) {
        LOGGER.debug(String.format("Attempt to send zipcode: %s", zipCode));
        zipCodeInput.sendKeys(zipCode);
    }

    /**
     * This method clicks Continue button
     */
    @Step("Click continue button")
    public void clickContinue() {
        LOGGER.debug(String.format("Attempt to click Continue button: %s", continueButton));
        continueButton.click();
    }
}
