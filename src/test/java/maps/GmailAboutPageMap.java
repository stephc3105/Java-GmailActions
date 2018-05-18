package maps;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GmailAboutPageMap extends Map {

    @FindBy(css = ".gmail-nav > div > a:nth-child(2)")
    private WebElement signInLink;

    public WebElement getSignInLink() {
        return signInLink;
    }

}
