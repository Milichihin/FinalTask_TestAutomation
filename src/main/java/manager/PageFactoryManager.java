package manager;

import org.openqa.selenium.WebDriver;
import pages.*;

public class PageFactoryManager {

    WebDriver driver;

    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage() { return new HomePage(driver); }

    public CartPage getCartPage() { return new CartPage(driver); }

    public JoinPage getJoinPage() { return new JoinPage(driver); }

    public LogInPage getLogInPage() { return new LogInPage(driver); }

    public ProductPage getProductPage() { return new ProductPage(driver); }

    public SalesPage getSalesPage() { return new SalesPage(driver); }

    public SaveListsPage getSaveListsPage() { return new SaveListsPage(driver); }

    public SearchResultsPage getSearchResultsPage() { return new SearchResultsPage(driver); }



}
