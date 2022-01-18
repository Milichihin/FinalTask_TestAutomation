package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JoinPage extends BasePage{
    public JoinPage(WebDriver driver) {
        super(driver);
    }


   @FindBy(xpath = "//input[@type=\"email\"]")
    private WebElement emailField;

    @FindBy(xpath = "//span[@id='Email-error']")
    private WebElement emailError;

    @FindBy(xpath = "//input[@id='FirstName']")
    private WebElement firstNameField;

    @FindBy(xpath = "//input[@id='LastName']")
    private WebElement lastNameField;

    @FindBy(xpath = "//input[@id='Password']")
    private WebElement passwordField;

    @FindBy(xpath = "//span[@id='Password-error']")
    private WebElement passwordError;

    public void fillEmailField(final String email) {
        emailField.sendKeys(Keys.chord(Keys.CONTROL, "a"), email);
    }

    public void isEmailError() { emailError.isDisplayed(); }

    public void fillFirstNameField(final String fName) {
        firstNameField.sendKeys(Keys.chord(Keys.CONTROL, "a"), fName);
    }

    public void fillLastNameField(final String lName) {
        lastNameField.sendKeys(Keys.chord(Keys.CONTROL, "a"), lName);
    }

    public void fillPasswordField(final String password) {
        passwordField.sendKeys(Keys.chord(Keys.CONTROL, "a"), password);
        passwordField.sendKeys(Keys.RETURN);
    }

    public void isPasswordError() { passwordError.isDisplayed(); }

    public WebElement getEmailError(){
        return emailError;
    }

    public WebElement getPasswordError(){
        return passwordError;
    }

}
