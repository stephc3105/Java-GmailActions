package maps;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ComposeEmailMap extends Map {

    @FindBy(css = ".aic > .z0 > div")
    private WebElement composeButton;

    @FindBy(name = "to")
    private WebElement toAddressField;

    @FindBy(name = "subjectbox")
    private WebElement subjectField;

    @FindBy(css = ".Ap div:nth-child(2) > div")
    private WebElement emailBody;

    @FindBy(css = ".aDh > table > tbody > tr > td > div > .T-I")
    private WebElement sendEmailButton;

    @FindBy(css = ".gU > div > div > div > div > div > div.og")
    private WebElement discardEmail;

    /**
     * This method gets the Compose button to compose a new email.
     *
     * @return composeButton
     */
    public WebElement getComposeButton() {
        return composeButton;
    }

    /**
     * This method gets the text field for the To address of an email
     *
     * @return toAddressField
     */
    public WebElement getToAddressField() {
        return toAddressField;
    }

    /**
     * This method gets the text field for the Subject of an email
     *
     * @return subjectField
     */
    public WebElement getSubjectField() {
        return subjectField;
    }

    /**
     * This method gets the text field for the body of an email
     *
     * @return emailBody
     */
    public WebElement getEmailBody() {
        return emailBody;
    }

    /**
     * This method gets the Send button to send an email
     *
     * @return sendEmailButton
     */
    public WebElement getSendEmailButton() {
        return sendEmailButton;
    }

    /**
     * This method gets the close button on a new email to discard the email
     *
     * @return discardEmail
     */
    public WebElement getDiscardEmail() {
        return discardEmail;
    }

}
