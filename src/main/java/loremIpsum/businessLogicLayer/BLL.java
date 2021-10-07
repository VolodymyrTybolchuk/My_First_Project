package loremIpsum.businessLogicLayer;


import loremIpsum.pages.AfterGenerationPage;
import loremIpsum.pages.AfterGenerationResultPage;
import loremIpsum.pages.HomePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BLL {
    WebDriver driver;

    public BLL(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickChangeLanguageButton() {
        HomePage homePage = new HomePage(driver);
        homePage.clickChangeLanguageButton();
    }

    public String getKeyword() {
        HomePage homePage = new HomePage(driver);
        return homePage.getKeyword();
    }

    public void clickGenerateLoremIpsumButton() {
        HomePage homePage = new HomePage(driver);
        homePage.clickGenerateLoremIpsumButton();
    }

    public String getTextOfFirstParagraph() {
        HomePage homePage = new HomePage(driver);
        return homePage.getTextOfFirstParagraph();
    }

    public void sendKeysToInputFieldForGeneration(String inputValue) {
        HomePage homePage = new HomePage(driver);
        homePage.sendKeysToInputFieldForGeneration(inputValue);
    }

    public void chooseRadioButton(String inputValue) {
        HomePage homePage = new HomePage(driver);
        homePage.setValueToRadioButton(inputValue);
    }

    public String getTextResult() {
        AfterGenerationResultPage afterGenerationResultPage = new AfterGenerationResultPage(driver);
        return afterGenerationResultPage.getTextResult();
    }

    public void clickOnCheckbox() {
        HomePage homePage = new HomePage(driver);
        homePage.clickOnCheckbox();
    }

    public List<WebElement> getParagraphs() {
        AfterGenerationPage afterGenerationPage = new AfterGenerationPage(driver);
        return afterGenerationPage.getParagraphs();
    }

    public void implicitWait(long timeToWait) {
        driver.manage().timeouts().implicitlyWait(timeToWait, TimeUnit.SECONDS);
    }

    public void waitForPageLoadComplete(long timeToWait) {
        new WebDriverWait(driver, timeToWait).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }
}
