package loremipsum.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AfterGenerationPage extends BasePage {
    @FindAll(@FindBy(xpath = "//div[@id='lipsum']/p"))
    private List<WebElement> paragraphs;

    public AfterGenerationPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getParagraphs() {
        return paragraphs;
    }
}
