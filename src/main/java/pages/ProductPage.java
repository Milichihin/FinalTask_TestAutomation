package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[@id='product-add-button']")
    private WebElement addToBagButton;

    public void clickAddToBagButton(){
        addToBagButton.click();
    }

}
