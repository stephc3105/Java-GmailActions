package maps;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GmailInboxMap extends Map {

    @FindBy(partialLinkText = "Inbox")
    private WebElement inboxLink;

    @FindBy(css = ".zA > td > div.oZ-jc > div")
    private WebElement emailCheckbox;

    /**
     * This method gets the Inbox link
     *
     * @return inboxLink
     */
    public WebElement getInboxLink() {
        return inboxLink;
    }

    /**
     * This method gets the checkbox of any email in the list
     *
     * @return emailCheckbox
     */
    public WebElement getEmailCheckbox() {
        return emailCheckbox;
    }


}
