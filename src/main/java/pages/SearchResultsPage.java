package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class SearchResultsPage extends BasePage {

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[@data-auto-id=\"saveForLater\"]")
    private List<WebElement> saveIconsInProductCards;

    @FindBy(xpath = "//article[@class='_2qG85dG']")
    private List<WebElement> listOfProductCards;

    @FindBy(xpath = "//div[@class=\"_3J74XsK\"]")
    private List<WebElement> titlesOfProducts;

    @FindBy(xpath = "//a[@data-auto-id='loadMoreProducts']")
    private WebElement loadMoreButton;

    @FindBy(css = "body")
    private WebElement body;

    @FindBy(xpath = "//a[@id='men-floor']")
    private WebElement menuMan;

    public WebElement getSaveIconsInProductCards() {
        return saveIconsInProductCards.get(0);
    }

    public void clickFirstSaveIcon(){
        saveIconsInProductCards.get(0).click();
    }

    public WebElement getBody() {
        return body;
    }

    public WebElement getFirstProductCard() {
        return listOfProductCards.get(0);
    }

    public void clickFirstProductCard() {
        getFirstProductCard().click();
    }

    public boolean checkThatUrlContainsSearchWord(String word){
        return (driver.getCurrentUrl().contains(word));
    }

    public boolean isOnlySearchedBrands ( String brand) {
        int count = 0;
        for ( WebElement el: titlesOfProducts) {
            if (el.getAttribute("textContent").contains(brand)) {
                count++;
            }
        }
        return ( count == titlesOfProducts.size());
    }

    public boolean amountComparing( String firstAmountOfCards ){
//        int num = listOfProductCards.size();
        String str = Integer.toString(listOfProductCards.size());
        return (str == firstAmountOfCards);
    }

    public void clickLoadMoreButton() { loadMoreButton.click(); }

    public boolean secondComparing( String secondAmountOfCards ){
        int num = listOfProductCards.size();
        String str = Integer.toString(num);
        return (Integer.toString(listOfProductCards.size()) == secondAmountOfCards);
    }

}
