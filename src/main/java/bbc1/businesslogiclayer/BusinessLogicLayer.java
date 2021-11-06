package bbc1.businesslogiclayer;

import org.openqa.selenium.WebDriver;
import bbc1.pages.HomePage;
import bbc1.pages.NewsPage;

public class BusinessLogicLayer {
    WebDriver driver;

    public BusinessLogicLayer(WebDriver driver){
        this.driver=driver;
    }

    public HomePage getHomePage(){
        return new HomePage(driver);
    }
    public NewsPage getNewsPage(){
        return new NewsPage(driver);
    }
}
