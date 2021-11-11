package bbc1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CoronavirusPage extends BasePage{
    @FindBy(xpath = "//a[@class='nw-o-link'][contains(.,'Your Coronavirus Stories')][1]")
    private WebElement yourCoronavirusStoriesTab;
    public CoronavirusPage(WebDriver driver) {
        super(driver);
    }
    public void clickYourCoronavirusStoriesTab(){
        yourCoronavirusStoriesTab.click();
    }
}
