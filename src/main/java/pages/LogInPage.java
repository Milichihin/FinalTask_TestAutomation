package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LogInPage extends BasePage {

    public LogInPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[text()=\"Sign in\"]")
    private WebElement signInForm;

    @FindBy(xpath = "//input[@id='EmailAddress']")
    private WebElement emailField;

    @FindBy(xpath = "//span[@id='EmailAddress-error']")
    private WebElement emailError;

    @FindBy(xpath = "//input[@id='Password']")
    private WebElement passwordField;

    @FindBy(xpath = "//span[@id='Password-error']")
    private WebElement passwordError;

    @FindBy(xpath = "//input[@id='signin']")
    private WebElement signInButton;

    @FindBy(xpath = "//div[@class='error-block']")
    private WebElement generalErrorMessage;



    public WebElement getGeneralErrorMessage() {
        return generalErrorMessage;
    }

    public WebElement getMailErrorMessage() {
        return emailError;
    }

    public WebElement getPasswordErrorMessage() {
        return passwordError;
    }

    public void isSignInFormVisible() { signInForm.isDisplayed(); }

    public void fillEmailPasswordInField(final String email, final String password) {
        emailField.sendKeys(Keys.chord(Keys.CONTROL, "a"), email);
        if (getMailErrorMessage() == null ) {
            passwordField.sendKeys(Keys.chord(Keys.CONTROL, "a"), password);
        } else {
            passwordField.sendKeys(Keys.chord(Keys.CONTROL, "a"), password);
        }
    }

    public void clickSignInButton(){ signInButton.click(); }

    public void isErrorMessage() { generalErrorMessage.isDisplayed(); }


}
