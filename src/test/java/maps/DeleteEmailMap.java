package maps;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeleteEmailMap extends Map {

    @FindBy(css = ".oZ-jc > .T-Jo-auh")
    private WebElement emailWithinInbox;

    @FindBy(css = ".aDF")
    private WebElement deleteActionOption;

    /**
     * This method gets any email in the email in the list
     *
     * @return emailWithinInbox
     */
    public WebElement getEmailWithinInbox() {
        return emailWithinInbox;
    }

    /**
     * This method gets the Delete option in the actions menu when a user right clicks on an email
     *
     * @return deleteActionOption
     */
    public WebElement getDeleteActionOption() {
        return deleteActionOption;
    }

}
