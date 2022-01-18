package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//nav[@class='_3EAPxMS']/div[@class='srMPwPy']/div[@class='_3C_NQPb']")
    private WebElement mainMenu;

    @FindBy(xpath = "//input[@id='chrome-search']")
    private WebElement searchBar;

    @FindBy(xpath = "//button[@data-testid='search-button-inline']")
    private WebElement searchButton;

    @FindBy(xpath = "//a[@data-testid='women-floor']")
    private WebElement womenMenu;

    @FindBy(xpath = "//a[@data-testid='men-floor']")
    private WebElement menMenu;

    @FindBy(xpath = "//span[@type='accountUnfilled']")
    private WebElement accountMenu;

    @FindBy(xpath = "//a[@data-testid='myaccount-link']")
    private WebElement myAccountLink;

    @FindBy(xpath = "//a[@data-testid='signup-link']")
    private WebElement joinLink;

    @FindBy(xpath = "//a[@data-testid='savedItemsIcon']")
    private WebElement saveListsMenu;

    @FindBy(xpath = "//a[@data-testid='miniBagIcon']")
    private WebElement cartMenu;

    @FindBy(xpath = "//button[@data-testid='miniBagIcon']")
    private WebElement filledCartIcon;

    @FindBy(xpath = "//a[@data-test-id='bag-link']")
    private WebElement viewBagButton;

    @FindBy(xpath = "(//button[@class='_6iPIuvw'])[2]")
    private WebElement closeBagModal;

    @FindBy(xpath = "//div[@id='chrome-footer']")
    private WebElement footer;

    @FindBy(xpath = "//span[text()=\"You're in\"]")
    private WebElement locationMenu;

    @FindBy(xpath = "//select[@id='country']")
    private WebElement locationModalWindow;


    public void openHomePage(String url) {
        driver.get(url);
    }

    public WebElement getFilledCartIcon(){
        return filledCartIcon;
    }

    public WebElement getCloseBagModal(){
        return closeBagModal;
    }

    public WebElement getLocationModalWindow(){
        return locationModalWindow;
    }

    public WebElement getMyAccountLink(){
        return myAccountLink;
    }

    public WebElement getJoinLink(){
        return joinLink;
    }

    public WebElement getSearchButton(){
        return searchButton;
    }

    public void isMainMenuVisible() {
        mainMenu.isDisplayed();
    }

    public void isSearchBarVisible() {
        searchBar.isDisplayed();
    }

    public void isWomenMenuVisible() {
        womenMenu.isDisplayed();
    }

    public void isMenMenuVisible() {
        menMenu.isDisplayed();
    }

    public void isAccountMenuVisible() {
        accountMenu.isDisplayed();
    }

    public void isSaveListsMenuVisible() {
        saveListsMenu.isDisplayed();
    }

    public void isCartMenuVisible() {
        cartMenu.isDisplayed();
    }

    public void isFooterVisible() {
        footer.isDisplayed();
    }

    public void searchByKeyWord(final String searchText) {
        searchBar.clear();
        searchBar.sendKeys(searchText);
    }

    public void clickSaveListsMenu() {  saveListsMenu.click(); }

    public void clickSearchButton() {
        searchButton.click();
    }

    public void clickViewBagButton() { viewBagButton.click(); }

    public void clickLocationMenu() { locationMenu.click(); }

    public void clickAccountMenu() { accountMenu.click(); }

    public void clickMyAccountLink() { myAccountLink.click(); }

    public void clickJoinLink() { joinLink.click(); }

    public boolean isLocationCorrect(String location) {
        return (locationModalWindow.getAttribute("value") == location);
    }

}
