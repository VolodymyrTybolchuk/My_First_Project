package loremIpsum.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import loremIpsum.businesslogiclayer.BusinessLogicLayer;
import loremIpsum.pages.AfterGenerationPage;
import loremIpsum.pages.AfterGenerationResultPage;
import loremIpsum.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DefinitionSteps {
    private static Integer counterOfParagraphs = 0;
    private static final long DEFAULT_TIME = 120;
    WebDriver driver;
    BusinessLogicLayer businessLogicLayer;
    HomePage homePage;
    AfterGenerationResultPage afterGenerationResultPage;
    AfterGenerationPage afterGenerationPage;

    @Before
    public void testSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        businessLogicLayer = new BusinessLogicLayer(driver);
    }

    @And("User opens {string}")
    public void openPage(final String url) {
        homePage = businessLogicLayer.getHomePage();
        homePage.openHomePage(url);
        homePage.waitForPageLoadComplete(DEFAULT_TIME);
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @When("User clicks changing language button")
    public void userClicksChangingLanguageButton() {
        homePage.clickChangeLanguageButton();
    }

    @Then("User checks correctness of {string}")
    public void userChecksCorrectnessOfKeyword(final String keyword) {
        homePage.waitForPageLoadComplete(DEFAULT_TIME);
        assertEquals(keyword, homePage.getKeyword());
    }

    @When("User clicks “Generate Lorem Ipsum” button")
    public void userClicksGenerateLoremIpsumButton() {
        homePage.clickGenerateLoremIpsumButton();
    }

    @Then("User checks {string} on first paragraph")
    public void userChecksTextOnFirstParagraph(final String expectedText) {
        homePage.waitForPageLoadComplete(DEFAULT_TIME);
        assertEquals(expectedText, homePage.getTextOfFirstParagraph());
    }

    @Then("User checks {string} result of generation")
    public void userChecksResultOfGeneration(String expectedResult) {
        afterGenerationResultPage = businessLogicLayer.getAfterGenerationResultPage();
        afterGenerationResultPage.waitForPageLoadComplete(DEFAULT_TIME);
        assertTrue(afterGenerationResultPage.getTextResult().contains(expectedResult));
    }

    @And("User clicks on checkbox near to “Generate Lorem Ipsum” button")
    public void userClicksOnCheckboxNearToGenerateLoremIpsumButton() {
        homePage.clickOnCheckbox();
    }

    @Then("User checks that text not starts with {string}")
    public void userChecksThatTextNotStartsWithFalseResult(final String falseResult) {
        homePage.waitForPageLoadComplete(DEFAULT_TIME);
        assertTrue(homePage.getTextAfterClickingCheckboxAndGeneration().startsWith(falseResult) == false);
    }

    @And("User put parameter{string} to input field")
    public void userPutParameterToInputField(String inputParameter) {
        homePage.sendKeysToInputFieldForGeneration(inputParameter);
    }

    @And("User determines number of each paragraph that contains {string}")
    public void userDeterminesNumberOfEachParagraphThatContainsWord(final String word) {
        afterGenerationPage = businessLogicLayer.getAfterGenerationPage();
        afterGenerationPage.waitForPageLoadComplete(DEFAULT_TIME);
        afterGenerationPage.getParagraphs().stream().flatMap(x -> {
            if (x.getText().contains(word)) {
                counterOfParagraphs++;
                return Stream.of(x);
            }
            return Stream.empty();
        }).collect(Collectors.toList());
    }

    @Then("User checks if average number of paragraphs that contains keyword is more then {string}")
    public void userChecksIfAverageNumberOfParagraphsThatContainsKeywordIsMoreThenExpectedAverageResult(final String boundaryValue) {
        Double paragraphsWithWord = Double.valueOf(counterOfParagraphs);
        Double averageNumber = 50d / paragraphsWithWord;
        Double numberOfBoundaryValue = Double.parseDouble(boundaryValue);
        assertTrue(averageNumber >= numberOfBoundaryValue);
    }

    @And("User choose {string}")
    public void userChooseRadiobutton(String radiobutton) {
        homePage.setValueToRadioButton(radiobutton);
    }
}
