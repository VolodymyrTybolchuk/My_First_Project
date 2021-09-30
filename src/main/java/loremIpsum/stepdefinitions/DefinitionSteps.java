package loremIpsum.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import loremIpsum.manager.PageFactoryManager;
import loremIpsum.pages.AfterGenerationPage;
import loremIpsum.pages.AfterGenerationResultPage;
import loremIpsum.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.stream.Collectors;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DefinitionSteps {
    private static final long DEFAULT_TIME = 120;
    WebDriver driver;
    PageFactoryManager pageFactoryManager;
    HomePage homePage;
    AfterGenerationResultPage afterGenerationResultPage;
    AfterGenerationPage afterGenerationPage;

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


    @And("User clicks *words* radio button")
    public void userClicksWordsRadioButton() {
        homePage.clickWordsRadioButton();
    }

    @And("User clicks *bytes* radio button")
    public void userClicksBytesRadioButton() {
        homePage.clickBytesRadioButton();
    }

    @Then("User checks {string} result of generation")
    public void userChecksResultOfGeneration(String expectedResult) {
        afterGenerationResultPage=pageFactoryManager.getAfterGenerationResultPage();
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
        assertTrue(homePage.getTextAfterClickingCheckboxAndGeneration().startsWith(falseResult)==false);
    }

    @And("User put parameter{string} to input field")
    public void userPutParameterToInputField(String inputParameter) {
        homePage.sendKeysToInputFieldForGeneration(inputParameter);
    }

    @And("User determines number of each paragraph that contains {string}")
    public void userDeterminesNumberOfEachParagraphThatContainsWord(final String word) {
        afterGenerationPage=pageFactoryManager.getAfterGenerationPage();
        afterGenerationPage.waitForPageLoadComplete(DEFAULT_TIME);
        afterGenerationPage.getParagraphs().stream().filter(x-> x.getText().contains(word)).collect(Collectors.toList());
    }
}
