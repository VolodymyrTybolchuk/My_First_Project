package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class TextAfterGenerationTest extends BaseTest {
    private static final String FALSE_KEYPHRASE = "Lorem ipsum";

    @Test
    public void checkTextBeginningAfterGenerationWithoutActivatedCheckbox() {
        getBusinessLogicLayer().clickOnCheckbox();
        getBusinessLogicLayer().clickGenerateLoremIpsumButton();
        assertTrue(getBusinessLogicLayer().getTextOfFirstParagraph().startsWith(FALSE_KEYPHRASE) == false);
    }
}
