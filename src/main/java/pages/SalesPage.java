package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class SalesPage extends BasePage {

    public SalesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//p[text()=\"VIEW ALL\"]")
    private WebElement viewAllButton;

    @FindBy(xpath = "//article[@class='_2qG85dG']")
    private List<WebElement> listOfSalesProducts;

    @FindBy(xpath = "//div[@class='_1MVUcS8']")
    private List<WebElement> saleLabelInProductCard;

    public void clickViewAllCard(){ viewAllButton.click(); }

    public boolean isSaleLabelForEachProduct() {
        return (listOfSalesProducts.size() == saleLabelInProductCard.size());
    }



}
