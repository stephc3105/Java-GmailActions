package maps;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GmailLoginMap extends Map {

    @FindBy(id = "identifierId")
    private WebElement emailText;

    @FindBy(css = ".qhFLie > div > content.CwaK9 > span")
    private WebElement emailNext;

    @FindBy(css = "#password > div > div input")
    private WebElement passwordText;

    @FindBy(id = "passwordNext")
    private WebElement passwordNext;

    public WebElement getEmailText() {
        return emailText;
    }

    public WebElement getEmailNext() {
        return emailNext;
    }

    public WebElement getPasswordText() {
        return passwordText;
    }

    public WebElement getPasswordNext() {
        return passwordNext;
    }

}
