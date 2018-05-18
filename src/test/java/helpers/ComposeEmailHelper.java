package helpers;

import maps.ComposeEmailMap;
import maps.MapBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ComposeEmailHelper {

    public WebDriver driver;
    public ComposeEmailMap composeEmailMap;

    public ComposeEmailHelper(WebDriver driver) {

        this.driver = driver;
        composeEmailMap = MapBuilder.getInstance(driver, ComposeEmailMap.class);

    }

    public void composeEmail(String toAddress, String subject, String message) throws InterruptedException {

        WebDriverWait driverWait = new WebDriverWait(driver, 20);

        // Click the Compose button
        driverWait.until(ExpectedConditions.elementToBeClickable(composeEmailMap.getComposeButton()));
        composeEmailMap.getComposeButton().click();

        // Type in the To: field
        driverWait.until(ExpectedConditions.elementToBeClickable(composeEmailMap.getToAddressField()));
        composeEmailMap.getToAddressField().sendKeys(toAddress);
        composeEmailMap.getToAddressField().sendKeys(Keys.ENTER);

        // Add a Subject
        composeEmailMap.getSubjectField().sendKeys(subject);

        // Compose email
        composeEmailMap.getEmailBody().sendKeys(message);

        // Click Send
        composeEmailMap.getSendEmailButton().click();

        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("link_vsm")));
        Thread.sleep(2000);

    }

}
