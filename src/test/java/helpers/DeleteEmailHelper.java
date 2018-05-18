package helpers;

import maps.DeleteEmailMap;
import maps.GmailInboxMap;
import maps.MapBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DeleteEmailHelper {

    public WebDriver driver;
    public DeleteEmailMap deleteEmailMap;

    public DeleteEmailHelper(WebDriver driver) {

        this.driver = driver;
        deleteEmailMap = MapBuilder.getInstance(driver, DeleteEmailMap.class);

    }

    public void deleteEmail() throws InterruptedException {

        WebDriverWait driverWait = new WebDriverWait(driver, 20);

        // Delete email
        try {

            // right click an email in the list
            Actions emailActions = new Actions(driver);
            driverWait.until(ExpectedConditions.elementToBeClickable(deleteEmailMap.getEmailWithinInbox()));
            emailActions.moveToElement(deleteEmailMap.getEmailWithinInbox());
            emailActions.contextClick(deleteEmailMap.getEmailWithinInbox()).build().perform();
            driverWait.until(ExpectedConditions.elementToBeClickable(deleteEmailMap.getDeleteActionOption()));
            deleteEmailMap.getDeleteActionOption().click();

        } catch (TimeoutException e) {

            Actions emailActions = new Actions(driver);
            driverWait.until(ExpectedConditions.elementToBeClickable(deleteEmailMap.getEmailWithinInbox()));
            emailActions.moveToElement(deleteEmailMap.getEmailWithinInbox());
            emailActions.contextClick(deleteEmailMap.getEmailWithinInbox()).build().perform();
            driverWait.until(ExpectedConditions.elementToBeClickable(deleteEmailMap.getDeleteActionOption()));
            deleteEmailMap.getDeleteActionOption().click();

        }

        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".vh > span:nth-child(1)")));
        Thread.sleep(2000);

    }

}
