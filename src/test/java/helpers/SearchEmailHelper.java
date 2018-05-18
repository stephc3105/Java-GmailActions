package helpers;

import maps.MapBuilder;
import maps.SearchEmailMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchEmailHelper {

    public WebDriver driver;
    public SearchEmailMap searchEmailMap;

    public SearchEmailHelper(WebDriver driver) {

        this.driver = driver;
        searchEmailMap = MapBuilder.getInstance(driver, SearchEmailMap.class);

    }

    public void searchEmailForText(String searchText) {

        WebDriverWait driverWait = new WebDriverWait(driver, 20);

        // Search email
        driverWait.until(ExpectedConditions.elementToBeClickable(searchEmailMap.getSearchEmailTextField()));
        searchEmailMap.getSearchEmailTextField().sendKeys(searchText);
        searchEmailMap.getSearchButton().click();

    }

}
