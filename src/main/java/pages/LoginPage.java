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

    By userEmailField = By.cssSelector("#ap_email");
    By continueForUserEmailButton = By.xpath("//div/span/span/input[@id=\"continue\"]");
    By userPasswordField = By.cssSelector("#ap_password");
    By signInSubmitButton = By.cssSelector("#signInSubmit");
    By signInButton = By.cssSelector("#nav-link-accountList");

    /*@FindBy (css = "#ap_email")
    private WebElement userEmailField;
    @FindBy (xpath = "//div/span/span/input[@id=\"continue\"]")
    private WebElement continueForUserEmailButton;
    @FindBy(css = "#ap_password")
    private WebElement userPasswordField;
    @FindBy(css = "#signInSubmit")
    private WebElement signInSubmitButton;
    @FindBy(css = "#nav-link-accountList")
    private WebElement signInButton;*/

    public void clickSignInButton() {
        clickOnVisibleElement((By) signInButton);

    }

    public void typeUserEmail (String string) {
        sendKeys(userEmailField, string);
    }

    public void clickContinueForUserEmailButton() {
        clickOnVisibleElement((By) continueForUserEmailButton);
    }

    public void typeUserPassword(String string) {
        sendKeys(userPasswordField, string);
    }

    public void clickSignInSubmitButton() {
        clickOnVisibleElement((By) signInSubmitButton);

    }

    public void register(String email, String password) {
        clickSignInButton();
        typeUserEmail(email);
        clickContinueForUserEmailButton();
        typeUserPassword(password);
        clickSignInSubmitButton();
    }
}
