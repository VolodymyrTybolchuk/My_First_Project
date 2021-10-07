package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;


public class FishWordTest extends BaseTest {
    private static final String KEYWORD = "рыба";

    @Test
    public void checkTheKeywordAfterChangingLanguage() {
        getBusinessLogicLayer().clickChangeLanguageButton();
        assertTrue(getBusinessLogicLayer().getKeyword().contains(KEYWORD));
    }
}
