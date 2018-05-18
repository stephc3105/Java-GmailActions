package maps;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MoveEmailMap extends Map {

    @FindBy(css = ".G-Ni > div:nth-child(1) > .asa > .ase")
    private WebElement moveToButton;

    @FindBy(css = "div.J-JK-Jz")
    private WebElement createNewLabelOption;

    @FindBy(css = "input.xx")
    private WebElement newLabelNameTextField;

    /**
     * This method gets the Move to menu button that moves an email to another folder/label
     *
     * @return moveToButton
     */
    public WebElement getMoveToButton() {
        return moveToButton;
    }

    /**
     * This method gets the Create new label option in the Move To menu
     *
     * @return createNewLabelOption
     */
    public WebElement getCreateNewLabelOption() {
        return createNewLabelOption;
    }

    /**
     * This method gets the text field to enter a new label name
     *
     * @return newLabelNameTextField
     */
    public WebElement getNewLabelNameTextField() {
        return newLabelNameTextField;
    }

}
