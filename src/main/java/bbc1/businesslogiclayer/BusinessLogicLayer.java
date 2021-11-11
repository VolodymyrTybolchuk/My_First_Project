package bbc1.businesslogiclayer;

import bbc1.pages.*;
import org.openqa.selenium.WebDriver;

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
    public SearchPage getSearchPage(){return new SearchPage(driver);}
    public CoronavirusPage getCoronavirusPage(){return new CoronavirusPage(driver);}
    public YourCoronavirusStoriesPage getYourCoronavirusStoriesPage(){
        return new YourCoronavirusStoriesPage(driver);
    }
    public QuestionPage getQuestionPage(){return new QuestionPage(driver);}
}
