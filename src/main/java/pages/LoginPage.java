package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    @FindBy (css = "#ap_email")
    private WebElement userEmailField;
    @FindBy (xpath = "//div/span/span/input[@id=\"continue\"]")
    private WebElement continueForUserEmailButton;
    @FindBy(css = "#ap_password")
    private WebElement userPasswordField;
    @FindBy(css = "#signInSubmit")
    private WebElement signInSubmitButton;
    @FindBy(css = "#nav-link-accountList")
    private WebElement signInButton;

    public void clickSignInButton() {
        clickOnVisibleElement(signInButton);

    }
    private void clickOnVisibleElement(WebElement continueForUserEmailButton) {
    }

    public void typeUserEmail (String string) {
        sendKeys(userEmailField, string);
    }

    public void clickContinueForUserEmailButton() {
        clickOnVisibleElement(continueForUserEmailButton);
    }



    public void typeUserPassword(String string) {
        sendKeys(userPasswordField, string);
    }

    public void clickSignInSubmitButton() {
        clickOnVisibleElement(signInSubmitButton);

    }

    public void register(String email, String password) {
        clickSignInButton();
        typeUserEmail(email);
        clickContinueForUserEmailButton();
        typeUserPassword(password);
        clickSignInSubmitButton();
    }
}
