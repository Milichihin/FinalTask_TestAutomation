package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import java.util.concurrent.TimeUnit;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static org.junit.Assert.assertTrue;

public class DefinitionSteps {

    private static final long DEFAULT_TIMEOUT = 60;

    WebDriver driver;
    HomePage homePage;
    CartPage cartPage;
    JoinPage joinPage;
    LogInPage logInPage;
    ProductPage productPage;
    SalesPage salesPage;
    SaveListsPage saveListsPage;
    SearchResultsPage searchResultsPage;
    PageFactoryManager pageFactoryManager;

    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }

    @And("User opens {string} page")
    public void openPage(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }

    @And("User checks `Main menu` visibility")
    public void checkMainMenuVisibility() {
        homePage.isMainMenuVisible();
    }

    @And("User checks search bar visibility")
    public void checkSearchBarVisibility() {
        homePage.isSearchBarVisible();
    }

    @And("User checks `Women menu` visibility")
    public void checkWomenMenuVisibility() {
        homePage.isWomenMenuVisible();
    }

    @And("User checks `Men menu` visibility")
    public void checkMenMenuVisibility() {
        homePage.isMenMenuVisible();
    }

    @And("User checks `Account menu` visibility")
    public void checkAccountMenuVisibility() {
        homePage.isAccountMenuVisible();
    }

    @And("User checks `Save lists menu` visibility")
    public void checkSaveListsMenuVisibility() {
        homePage.isSaveListsMenuVisible();
    }

    @And("User checks `Cart menu` visibility")
    public void checkCartMenuVisibility() {
        homePage.isCartMenuVisible();
    }

    @And("User checks footer visibility")
    public void checkFooterVisibility() {
        homePage.isFooterVisible();
    }

    @And("User makes search by keyword {string}")
    public void makeSearchByKeywordKeyword(final String word) {
        homePage.searchByKeyWord(word);
    }

    @When("User clicks search button")
    public void clickSearchButton() {
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getSearchButton());
        homePage.clickSearchButton();
    }

    @And("User clicks first `Save icon`")
    public void clickFirstSaveIcon() {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, searchResultsPage.getSaveIconsInProductCards());
        searchResultsPage.clickFirstSaveIcon();
    }

    @When("User clicks `Save lists menu`")
    public void clickSaveListsMenu() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.clickSaveListsMenu();
    }

    @And("User checks save list visibility")
    public void checkSaveListVisibility() {
        saveListsPage = pageFactoryManager.getSaveListsPage();
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        saveListsPage.isSaveListNotEmpty();
    }

    @And("User clicks first product card")
    public void clickFirstProductCard() {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        homePage.scrollDown("300");
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, searchResultsPage.getFirstProductCard());
        searchResultsPage.clickFirstProductCard();
    }

    @And("User clicks `Add to Bag` button")
    public void clickAddToBagButton() {
        productPage = pageFactoryManager.getProductPage();
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        productPage.clickAddToBagButton();
    }

    @And("User clicks `Cart Menu` button")
    public void clickCartMenuButton() {
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getCloseBagModal());
        homePage.getCloseBagModal().click();
        homePage.waitImplicitly(5);
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getFilledCartIcon());
        homePage.getFilledCartIcon().click();
    }

    @When("User clicks `View Bag` button")
    public void clickViewBagButton() {
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getCloseBagModal());
        homePage.clickViewBagButton();
    }

    @Then("User checks list of selected products")
    public void checkListOfSelectedProducts() {
        cartPage = pageFactoryManager.getCartPage();
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        cartPage.isSelectedProductsInCart();
    }

    @When("User clicks `Location menu`")
    public void clickLocationMenu() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.clickLocationMenu();
    }

    @Then("User checks that location is {string}")
    public void checkThatLocationIsLocation(final String location) {
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getLocationModalWindow());
        homePage.isLocationCorrect(location);

    }

    @When("User clicks `View all` card")
    public void clickViewAllCard() {
        salesPage = pageFactoryManager.getSalesPage();
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        salesPage.clickViewAllCard();
    }

    @And("User checks availability of `sale label` on each product card")
    public void checkAvailabilityOfSaleLabelOnEachProductCard() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        salesPage.isSaleLabelForEachProduct();
    }

    @And("User checks that url contains search {string} word")
    public void checkThatUrlContainsSearchWord( final String keyword) {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertTrue(searchResultsPage.checkThatUrlContainsSearchWord(keyword));
    }

    @Then("User see only searched {string}")
    public void seeOnlySearchedBrand( final String brand) {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        searchResultsPage.isOnlySearchedBrands(brand);
    }

    @Then("User checks that amount of `Product Cards` is {string}")
    public void checkThatAmountOfProductCardsIsFirstAmountOfCards( final String firstAmountOfCards) {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        searchResultsPage.amountComparing(firstAmountOfCards);
    }

    @And("User clicks on `Load More` button")
    public void clickOnLoadMoreButton() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
//        searchResultsPage.scrollToEndOfPage(searchResultsPage.getBody());
        searchResultsPage.clickLoadMoreButton();
        homePage.scrollToEndOfPage(searchResultsPage.getBody());
        homePage.waitImplicitly(5);
        homePage.scrollToEndOfPage(searchResultsPage.getBody());
        homePage.waitImplicitly(5);
        homePage.scrollToEndOfPage(searchResultsPage.getBody());
        homePage.waitImplicitly(5);
        homePage.scrollToEndOfPage(searchResultsPage.getBody());
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }

    @Then("User checks that newAmount of `Product Cards` is {string}")
    public void checkThatNewAmountOfProductCardsIsFirstAmountOfCards( final String secondAmountOfCards) {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.scrollDown("400");
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        searchResultsPage.secondComparing(secondAmountOfCards);
    }

    @And("User clicks `Account menu`")
    public void clickAccountMenu() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.clickAccountMenu();
    }

    @When("User clicks `My Account` link")
    public void clickMyAccountField() {
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getMyAccountLink());
        homePage.clickMyAccountLink();
    }

    @Then("User checks `Sign In` form visibility")
    public void checkSignInFormVisibility() {
        logInPage = pageFactoryManager.getLogInPage();
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        logInPage.isSignInFormVisible();
    }

    @And("User fill {string} and {string} in `Email` field of form")
    public void fillEmailPasswordInForm(final String email, final String password) {
        logInPage.fillEmailPasswordInField(email, password);
    }

    @When("User clicks `Sign In` button")
    public void clickSignInButton() {
        logInPage.clickSignInButton();
    }

    @Then("User see error message")
    public void userSeeErrorMessage() {
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, logInPage.getGeneralErrorMessage());
        logInPage.isErrorMessage();
    }

    @And("User clicks `Join` link")
    public void clickJoinLink() {
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getJoinLink());
        homePage.clickJoinLink();
    }

    @When("User fill {string} in `Email` field of form to join")
    public void fillEmailInEmailFieldOfFormToJoin( final String email) {
        joinPage = pageFactoryManager.getJoinPage();
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        joinPage.fillEmailField(email);
        homePage.scrollDown("400");
    }

    @Then("User see `Email-error` message")
    public void userSeeEmailErrorMessage() {
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, joinPage.getEmailError());
        joinPage.isEmailError();
    }

    @And("User fill {string} in `First Name` field of form")
    public void fillFirstNameInFirstNameFieldOfForm( final String firstName) {
        joinPage.fillFirstNameField(firstName);
    }

    @And("User fill {string} in `Last Name` field of form")
    public void fillLastNameInLastNameFieldOfForm(final String lastName) {
        joinPage.fillLastNameField(lastName);
    }

    @When("User fill {string} in `Password` field of form to join")
    public void fillPasswordInPasswordFieldOfFormToJoin( final String password) {
        joinPage.fillPasswordField(password);
    }

    @Then("User see `Password-error` message")
    public void userSeePasswordErrorMessage() {
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, joinPage.getPasswordError());
        joinPage.isPasswordError();
    }

    @After
    public void tearDown() {
        driver.close();
    }
}
