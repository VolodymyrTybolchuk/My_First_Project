package bbc1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.openqa.selenium.Keys.ENTER;

public class NewsPage extends BasePage{
    @FindBy(xpath = "//h3[contains(.,'Scores dead in Sierra Leone tanker explosion')]")
    private WebElement mainArticle;
    @FindAll(@FindBy(xpath = "//h3[@class='gs-c-promo-heading__title gel-pica-bold nw-o-link-split__text']"))
    private List<WebElement> articleTitles;
    @FindBy(xpath = "//span[@aria-hidden][contains(text(),'Europe')][1]")
    private WebElement categoryLink;
    @FindBy(xpath = "//input[@id='orb-search-q']")
    private WebElement searchInput;
    @FindBy(xpath = "//a[@class='nw-o-link'][contains(.,'Coronavirus')][1]")
    private WebElement coronavirusTab;
    public NewsPage(WebDriver driver) {
        super(driver);
    }
    public String getTextOfMainArticle(){
        return mainArticle.getText();
    }
    public List<WebElement> getTitles(){
        return articleTitles;
    }
    public String getTextOfCategoryLink(){
        return categoryLink.getText();
    }
    public void enterSearchInput(final String input){
        searchInput.click();
        searchInput.sendKeys(input,ENTER);
    }
    public void clickCoronavirusTab(){
        coronavirusTab.click();
    }
}
