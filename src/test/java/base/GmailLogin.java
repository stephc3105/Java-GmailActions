package base;

import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.*;

import java.util.NoSuchElementException;
import java.util.logging.Logger;

public class GmailLogin extends FrameworkSetup {

    @Before
    public void signIn() throws Exception {

        logger = Logger.getLogger(log);
        logger.info("Signing in...");

        // Enter email
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("identifierId")));
        Thread.sleep(4000);
        driver.findElement(By.id("identifierId")).sendKeys(emailAddress); // email text field
        driver.findElement(By.cssSelector(".qhFLie > div > content.CwaK9 > span")).click(); // email Next button

        // Enter pw
        // TODO: Handle the case where Gmail asks for a phone number or password verification through a captcha
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#password > div > div input")));
        Thread.sleep(4000);
        driver.findElement(By.cssSelector("#password > div > div input")).sendKeys(password); // password text field
        driver.findElement(By.id("passwordNext")).click(); // password Next button
        // if a captcha is displayed, print out a message
        try {
            if (driver.findElement(By.cssSelector(".Xb9hP > input#ca")).isDisplayed()) {
                System.out.println("Gmail requires a captcha to be entered.");
            }
        } catch (NoSuchElementException noSuchElementException) {}

    }

}