package loremIpsum.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AfterGenerationResultPage extends BasePage {
    @FindBy(xpath = "//div[@id='generated']")
    private WebElement resultText;

    public AfterGenerationResultPage(WebDriver driver) {
        super(driver);
    }

    public String getTextResult() {
        String textResult = resultText.getText();
        return textResult;
    }

}
