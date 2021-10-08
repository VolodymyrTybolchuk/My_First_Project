package loremIpsum.businesslogiclayer;

import loremIpsum.pages.*;
import org.openqa.selenium.WebDriver;

public class BusinessLogicLayer {

    WebDriver driver;

    public BusinessLogicLayer(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage() {
        return new HomePage(driver);
    }

    public AfterGenerationResultPage getAfterGenerationResultPage() {
        return new AfterGenerationResultPage(driver);
    }
    public AfterGenerationPage getAfterGenerationPage(){
        return new AfterGenerationPage(driver);
    }
}