package tests;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class FirstParagraphAfterGenerationTest extends BaseTest {
    private static final String KEYPHRASE = "Lorem ipsum dolor sit amet, consectetur adipiscing elit";


    @Test
    public void checkTextBeginningAfterGeneration() {
        getBusinessLogicLayer().clickGenerateLoremIpsumButton();
        assertTrue(getBusinessLogicLayer().getTextOfFirstParagraph().startsWith(KEYPHRASE));
    }
}
