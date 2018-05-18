package maps;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchEmailMap extends Map {

    @FindBy(css = ".gsib_a > div > input:nth-child(1)")
    private WebElement searchEmailTextField;

    @FindBy(css = "#gbqfbw > button")
    private WebElement searchButton;

    /**
     * This method gets the text field for the email Search
     *
     * @return searchEmailTextField
     */
    public WebElement getSearchEmailTextField() {
        return searchEmailTextField;
    }

    /**
     * This method gets the Search button
     *
     * @return searchButton
     */
    public WebElement getSearchButton() {
        return searchButton;
    }

}
