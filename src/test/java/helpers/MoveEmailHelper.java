package helpers;

import maps.DeleteEmailMap;
import maps.GmailInboxMap;
import maps.MapBuilder;
import maps.MoveEmailMap;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MoveEmailHelper {

    public WebDriver driver;
    public MoveEmailMap moveEmailMap;

    public MoveEmailHelper(WebDriver driver) {

        this.driver = driver;
        moveEmailMap = MapBuilder.getInstance(driver, MoveEmailMap.class);

    }

    public void moveEmailToNewFolder(String newFolderName) {

        WebDriverWait driverWait = new WebDriverWait(driver, 30);
        GmailInboxMap gmailInboxMap = MapBuilder.getInstance(driver, GmailInboxMap.class);

        try {

            // Move email into a new folder
            driverWait.until(ExpectedConditions.elementToBeClickable(gmailInboxMap.getEmailCheckbox()));
            gmailInboxMap.getEmailCheckbox().click();
            driverWait.until(ExpectedConditions.visibilityOf(moveEmailMap.getMoveToButton()));
            moveEmailMap.getMoveToButton().click();
            moveEmailMap.getCreateNewLabelOption().click();

        } catch (StaleElementReferenceException e) {

            // Move email into a new folder
            driverWait.until(ExpectedConditions.elementToBeClickable(gmailInboxMap.getInboxLink())).click();
            gmailInboxMap.getInboxLink().click();
            driverWait.until(ExpectedConditions.elementToBeClickable(gmailInboxMap.getEmailCheckbox()));
            gmailInboxMap.getEmailCheckbox().click();
            driverWait.until(ExpectedConditions.visibilityOf(moveEmailMap.getMoveToButton()));
            moveEmailMap.getMoveToButton().click();
            moveEmailMap.getCreateNewLabelOption().click();

        }

        // Enter a new folder name
        driverWait.until(ExpectedConditions.elementToBeClickable(moveEmailMap.getNewLabelNameTextField()));
        moveEmailMap.getNewLabelNameTextField().sendKeys(newFolderName);
        // Click the Create button for a new label is not working
        // TODO: All of the following options will pass the test as if the button was clicked, however the button does not depress or create the folder
        // TODO: Option 1 (click directly on the element)
//        driver.findElement(By.name("ok")).click();

        // TODO: Option 2 (use the Actions class to move to the element and then click
//        Actions createFolder = new Actions(driver);
//        createFolder.moveToElement(driver.findElement(By.cssSelector(".Kj-JD-Jl > button:nth-child(1)"))).click().build().perform();

        // TODO: Option 3 (use key press to tab to the Create button and then hit Enter)
//        moveEmailMap.getNewLabelNameTextField().sendKeys(Keys.TAB);
//        driver.findElement(By.cssSelector(".xy > input")).sendKeys(Keys.TAB);
//        driver.findElement(By.cssSelector(".xx > option")).sendKeys(Keys.TAB);
//        driver.findElement(By.cssSelector(".Kj-JD-Jl > button:nth-child(1)")).sendKeys(Keys.ENTER);

        // TODO: Option 4 (Use Javascript to click the Create button)
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", driver.findElement(By.name("ok")));
//        executor.executeScript("arguments[0].click();", driver.findElement(By.cssSelector(".Kj-JD-Jl > button:nth-child(1)")));

    }

}
