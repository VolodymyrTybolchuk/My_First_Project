package bbc1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage{
@FindBy(xpath = "//p[contains(.,'Cities of Europe')]")
private WebElement firstFoundedArticleName;
    public SearchPage(WebDriver driver) {
        super(driver);
    }
    public String getTextOfFirstFoundedArticle(){
        return firstFoundedArticleName.getText();
    }
}
