package loremIpsum.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import loremIpsum.manager.PageFactoryManager;
import loremIpsum.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static org.junit.Assert.assertEquals;

public class DefinitionSteps {
    private static final long DEFAULT_TIME = 120;
    WebDriver driver;
    PageFactoryManager pageFactoryManager;
    HomePage homePage;

    @Before
    public void testSetUp(){
        chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager= new PageFactoryManager(driver);
    }

    @And("User opens {string}")
    public void openPage(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
        homePage.waitForPageLoadComplete(DEFAULT_TIME);
    }

    @After
    public void tearDown(){
        driver.close();
    }

    @When("User clicks changing language button")
    public void userClicksChangingLanguageButton() {
        homePage.clickChangeLanguageButton();
    }

    @Then("User checks correctness of {string}")
    public void userChecksCorrectnessOfKeyword(final String keyword) {
        homePage.waitForPageLoadComplete(DEFAULT_TIME);
        assertEquals(keyword,homePage.getKeyword());
    }

    @When("User clicks “Generate Lorem Ipsum” button")
    public void userClicksGenerateLoremIpsumButton() {
        homePage.clickGenerateLoremIpsumButton();
    }

    @Then("User checks {string} on first paragraph")
    public void userChecksTextOnFirstParagraph(final String expectedText) {
        homePage.waitForPageLoadComplete(DEFAULT_TIME);
        assertEquals(expectedText,homePage.getTextOfFirstParagraph());
    }
}
