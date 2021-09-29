package loremIpsum.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    @FindBy(xpath = "//a[contains(.,'Pyccкий')]")
    private WebElement changeLanguageButton;
    @FindBy(xpath = "//p[contains(.,'Lorem Ipsum - это')]")
    private WebElement textAfterChangingLanguage;
    @FindBy(xpath = "//input[@value='Generate Lorem Ipsum']")
    private WebElement generateLoremIpsumButton;
    @FindBy(xpath = "//div[@id='lipsum']//following-sibling::p[contains(.,'L')]")
    private WebElement textAfterClickingGenerateLoremIpsumButton;
    @FindBy(xpath = "//input[@type='text']")
    private WebElement inputFieldForGeneration;
    @FindBy(xpath = "//input[@value='bytes']")
    private WebElement bytesRadioButton;
    @FindBy(xpath = "//input[@value='words']")
    private WebElement wordsRadioButton;


    public HomePage(WebDriver driver) {
        super(driver);
    }

    private static final long DEFAULT_TIME = 120;

    public void clickChangeLanguageButton() {
        changeLanguageButton.click();
    }

    public String getKeyword() {
        String keyword = "some other result";
        if (textAfterChangingLanguage.getText().contains("рыба")) {
            keyword = "рыба";
        }
        return keyword;
    }
    public String getTextOfFirstParagraph() {
        String text = "some other result";
        if (textAfterClickingGenerateLoremIpsumButton.getText().startsWith("Lorem ipsum dolor sit amet, consectetur adipiscing elit")) {
            text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit";
        }
        return text;
    }
    public void clickGenerateLoremIpsumButton(){
        generateLoremIpsumButton.click();
    }

    public void openHomePage(String url) {
        driver.get(url);
    }

    public void sendKeysToInputFieldForGeneration(final String inputValue){
        inputFieldForGeneration.clear();
        inputFieldForGeneration.sendKeys(inputValue);
    }
    public void clickBytesRadioButton(){
        bytesRadioButton.click();
    }
    public void clickWordsRadioButton(){
        wordsRadioButton.click();
    }
}
