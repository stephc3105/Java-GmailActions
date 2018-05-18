package maps;

import org.openqa.selenium.WebDriver;

public abstract class Map {

    protected WebDriver driver;
    protected int DEFAULT_TIMEOUT_SECONDS = 30;

    protected void setWebDriver(WebDriver driver) { this.driver = driver; }

}
