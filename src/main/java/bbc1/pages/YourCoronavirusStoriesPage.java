package bbc1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YourCoronavirusStoriesPage extends BasePage{
    @FindBy(xpath = "//h3[contains(.,'Your questions answered: What questions do you have?')]")
    private WebElement questionTab;
    public YourCoronavirusStoriesPage(WebDriver driver) {
        super(driver);
    }
    public void clickQuestionTab(){
        questionTab.click();
    }
}
