package bbc1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    @FindBy(xpath = "//div[@id='orb-nav-links']//li[@class='orb-nav-newsdotcom']")
    private WebElement newsLink;
    public HomePage(WebDriver driver) {
        super(driver);
    }
    public void openHomePage(String url) {
        driver.get(url);
    }
public void clickNewsLink(){
        newsLink.click();
}
}
