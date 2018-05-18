package base;

import org.apache.commons.logging.LogFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class FrameworkSetup {

    private static String PROPERTIES = "webdriver.properties";
    private final Properties properties = new Properties();

    private final String BROWSER = "browser";
    private final String CHROME = "chrome";
    private final String BASE_URL = "baseUrl";

    protected static String baseUrl = "https://www.google.com/gmail/about/";
    protected String emailAddress = "sheldonc3.14159@gmail.com";
    protected String password = "";

    public static WebDriver driver;
    public Logger logger;
    public String log = "default";

    public static WebDriverWait driverWait;

    @BeforeClass
    public static void setUp() throws Exception {

        System.setProperty("webdriver.chrome.driver", "/Users/stephcruz/Automation/Drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driverWait = new WebDriverWait(driver, 20);

        driver.get(baseUrl);
        Thread.sleep(3000);
        driver.findElement(By.cssSelector(".gmail-nav > div > a:nth-child(2)")).click(); // Sign In link

    }

    @After
    public void tearDown() throws Exception {

        if (driver != null) { driver.quit(); }

    }

}
