package scripts;

import base.GmailLogin;
import helpers.ComposeEmailHelper;
import helpers.DeleteEmailHelper;
import helpers.MoveEmailHelper;
import helpers.SearchEmailHelper;
import maps.GmailInboxMap;
import maps.MapBuilder;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.logging.Logger;

public class gmailActions extends GmailLogin {

    String sendToEmail = "sheldonc3.14159@gmail.com";
    String emailSubject = "Test Subject";
    String emailMessage = "Hello John Doe\n" +
                          "It was great catching up with you yesterday. Hope to talk to you soon!\n" +
                          "From,\n" +
                          "Jane Doe";
    String searchText = "test";
    String newFolderName = "My Stuff";

    public ComposeEmailHelper composeEmail;
    public SearchEmailHelper searchEmail;
    public DeleteEmailHelper deleteEmail;
    public MoveEmailHelper moveEmail;

    GmailInboxMap gmailInboxMap;

    @Before
    public void setupBeforeTest() {

        logger = Logger.getLogger(log);

        composeEmail = new ComposeEmailHelper(driver);
        searchEmail = new SearchEmailHelper(driver);
        deleteEmail = new DeleteEmailHelper(driver);
        moveEmail = new MoveEmailHelper(driver);

        gmailInboxMap = MapBuilder.getInstance(driver, GmailInboxMap.class);

    }

    @Test
    public void testGmailActions() throws Exception {

        logger.info("<Start Test>");

        logger.info("Compose an email");
        composeEmail.composeEmail(sendToEmail, emailSubject, emailMessage);

        logger.info("Search for text in email: " + searchText);
        searchEmail.searchEmailForText(searchText);

        logger.info("Delete an email");
        deleteEmail.deleteEmail();

        logger.info("Click the Inbox link");
        try {
            driverWait.until(ExpectedConditions.elementToBeClickable(gmailInboxMap.getInboxLink())).click();
            gmailInboxMap.getInboxLink().click();
        } catch (StaleElementReferenceException staleElementReferenceException) {
            driverWait.until(ExpectedConditions.elementToBeClickable(gmailInboxMap.getInboxLink())).click();
            gmailInboxMap.getInboxLink().click();
        }

        logger.info("Move email into a new folder named " + newFolderName);
        moveEmail.moveEmailToNewFolder(newFolderName);

        logger.info("<End Test>");

    }

}
