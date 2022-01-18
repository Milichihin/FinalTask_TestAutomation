package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//li[@class=\"bag-item-holder\"]")
    private List<WebElement> selectedProducts;

    public boolean isSelectedProductsInCart(){
        return (selectedProducts.size() > 0);
    }

}
