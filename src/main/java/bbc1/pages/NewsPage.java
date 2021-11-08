package bbc1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class NewsPage extends BasePage{
    @FindBy(xpath = "//h3[contains(.,'Scores dead in Sierra Leone tanker explosion')]")
    private WebElement mainArticle;
    @FindAll(@FindBy(xpath = "//h3[@class='gs-c-promo-heading__title gel-pica-bold nw-o-link-split__text']"))
    private List<WebElement> articleTitles;
    public NewsPage(WebDriver driver) {
        super(driver);
    }
    public String getTextOfMainArticle(){
        return mainArticle.getText();
    }
    public List<WebElement> getTitles(){
        return articleTitles;
    }
}
