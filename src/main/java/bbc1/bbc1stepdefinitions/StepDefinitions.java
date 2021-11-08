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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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

    @Then("User checks correctness of all secondary articles titles")
    public void userChecksCorrectnessOfAllSecondaryArticlesTitles() {
        List<String> listOfTitles =
                List.of("Travis Scott 'devastated' by Texas festival deaths",
                        "Biden: Infrastructure bill is monumental step",
                        "Ex-PM condemns UK government as 'shameful'",
                        "Fleeing passengers shut down busy Spanish airport",
                        "Three injured in knife attack on German train",
                        "Greta Thunberg: COP26 is a failure and PR exercise",
                        "Brazil singer Mendonca dies in plane crash at 26",
                        "Ethiopia urges ex-soldiers to fight against rebels",
                        "Man found naked inside wall of US theatre",
                        "Ethiopia urges ex-soldiers to fight against rebels",
                        "Man found naked inside wall of US theatre",
                        "Chinese man convicted on aviation spy charges",
                        "Footballer struck by stray firework during game",
                        "Man City outclass Man Utd in derby win",
                        "How the world is reacting to COP26",
                        "The US state taking on an oil giant for greenwashing",
                        "Who is Greta Thunberg and what are her aims?",
                        "What you should know about climate change in Africa",
                        "'By helping out delegates I'm remembering granddad'",
                        "Travis Scott 'devastated' by Texas festival deaths",
                        "BBC World News TV",
                        "BBC World Service Radio",
                        "All on show - the museum displaying everything",
                        "The teen art prodigy who's refusing to turn pro",
                        "Striking pictures from around the world this week",
                        "Colin Powell: Funeral for 'great lion with big heart'",
                        "Abandoned dog sells for $25k at auction",
                        "Are Diwali fireworks to blame for Delhi smog?",
                        "As winter looms, reports of starvation in North Korea",
                        "Does the skyscraper still have a future?",
                        "Covid delays student's journey from slum to Sydney",
                        "'More than batons needed to control Ecuador's jails'",
                        "New ways into the lucrative world of data science",
                        "‘As a child I saw the plane crash that killed my sisters'",
                        "Lyse Doucet’s love letter to Kabul through nine treasured places",
                        "Revealed: The Cryptoqueen's £13.5m London penthouse",
                        "How to end Ethiopia's suffering after a year of war",
                        "The city trying to save the world",
                        "Why it's wrong to dismiss demisexuality",
                        "The city where you can't serve meat",
                        "Why Hollywood is shunning sex",
                        "How China shapes the world's coal",
                        "Penalised for showing emotion at work?",
                        "The village that tamed a 100ft wave",
                        "Autumn Nations Series: HT Wales 12-9 South Africa - Pollard late pen trims lead at break",
                        "England into semi-finals despite narrow defeat by South Africa",
                        "Barcelona surrender three-goal lead against Celta Vigo",
                        "Burnley 'stole point by pure luck' - Chelsea boss Tuchel",
                        "Rampant England claim 11-try win against Tonga as Smith sparks late flurry",
                        "'I'm coming home' - Barca confirm Xavi return");
        assertEquals(newsPage.getTitles().stream().map(x->x.getText()),listOfTitles);
    }

}
