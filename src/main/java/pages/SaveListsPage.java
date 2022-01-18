package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SaveListsPage extends BasePage {
    public SaveListsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//section[@class='productTilesWrapper_15Cf0']//ol//li")
    private List<WebElement> saveList;

    public boolean isSaveListNotEmpty(){
        return (saveList.size()>0);
    }




}
