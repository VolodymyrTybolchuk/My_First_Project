package bbc1.bbc1stepdefinitions;

import bbc1.businesslogiclayer.BusinessLogicLayer;
import bbc1.pages.HomePage;
import bbc1.pages.NewsPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static org.junit.Assert.assertEquals;

public class StepDefinitions {
    private static final long DEFAULT_TIME = 120;
    WebDriver driver;
    BusinessLogicLayer businessLogicLayer;
    HomePage homePage;
    NewsPage newsPage;

    @Before
    public void testSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        businessLogicLayer = new BusinessLogicLayer(driver);
    }
    @After
    public void tearDown(){
        driver.close();
    }
@And("User opens {string}")
    public void openPage(final String url){
        homePage=businessLogicLayer.getHomePage();
        homePage.openHomePage(url);
        homePage.waitForPageLoadComplete(DEFAULT_TIME);
}

    @When("User clicks news page link")
    public void userClicksNewsPageLink() {
        homePage.clickNewsLink();
    }

    @Then("User checks name correctness of main {string}")
    public void userChecksNameCorrectnessOfMainArticle(final String text) {
        newsPage=businessLogicLayer.getNewsPage();
        assertEquals(text, newsPage.getTextOfMainArticle());
    }
}
