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

    public ComposeEmailHelper composeEmailHelper;
    public SearchEmailHelper searchEmailHelper;
    public DeleteEmailHelper deleteEmailHelper;
    public MoveEmailHelper moveEmailHelper;

    GmailInboxMap gmailInboxMap;

    @Before
    public void setupBeforeTest() {

        logger = Logger.getLogger(log);

        composeEmailHelper = new ComposeEmailHelper(driver);
        searchEmailHelper = new SearchEmailHelper(driver);
        deleteEmailHelper = new DeleteEmailHelper(driver);
        moveEmailHelper = new MoveEmailHelper(driver);

        gmailInboxMap = MapBuilder.getInstance(driver, GmailInboxMap.class);

    }

    @Test
    public void testGmailActions() throws Exception {

        logger.info("<Start Test>");

        logger.info("Compose an email");
        composeEmailHelper.composeEmail(sendToEmail, emailSubject, emailMessage);

        logger.info("Search for text in email: " + searchText);
        searchEmailHelper.searchEmailForText(searchText);

        logger.info("Delete an email");
        deleteEmailHelper.deleteEmail();

        logger.info("Click the Inbox link");
        try {
            driverWait.until(ExpectedConditions.elementToBeClickable(gmailInboxMap.getInboxLink())).click();
            gmailInboxMap.getInboxLink().click();
        } catch (StaleElementReferenceException staleElementReferenceException) {
            driverWait.until(ExpectedConditions.elementToBeClickable(gmailInboxMap.getInboxLink())).click();
            gmailInboxMap.getInboxLink().click();
        }

        logger.info("Move email into a new folder named " + newFolderName);
        moveEmailHelper.moveEmailToNewFolder(newFolderName);

        logger.info("<End Test>");

    }

}
