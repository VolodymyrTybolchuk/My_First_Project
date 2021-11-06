package bbc1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewsPage extends BasePage{
    @FindBy(xpath = "//h3[contains(.,'Scores dead in Sierra Leone tanker explosion')]")
    private WebElement mainArticle;
    public NewsPage(WebDriver driver) {
        super(driver);
    }
    public String getTextOfMainArticle(){
        return mainArticle.getText();
    }
}
