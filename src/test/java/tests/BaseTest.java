package tests;

import loremipsum.businesslogiclayer.BLL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class BaseTest {
    private WebDriver driver;
    private static final String LOREM_IPSUM_URL = "https://lipsum.com/";


    @BeforeTest
    public void profileSetup() {
        chromedriver().setup();
    }

    @BeforeMethod
    public void testSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(LOREM_IPSUM_URL);
    }

    @AfterMethod
    public void tierDown() {
        driver.close();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public BLL getBusinessLogicLayer() {
        return new BLL(getDriver());
    }
}
