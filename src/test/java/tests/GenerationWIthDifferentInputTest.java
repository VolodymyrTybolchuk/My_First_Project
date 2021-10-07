package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class GenerationWIthDifferentInputTest extends BaseTest {
    private static final String WORDS = "words";
    private static final String BYTES = "bytes";
    private static final String PARAMETER1_FOR_WORDS = "10";
    private static final String PARAMETER2_FOR_WORDS = "-1";
    private static final String PARAMETER3_FOR_WORDS = "0";
    private static final String PARAMETER4_FOR_WORDS = "5";
    private static final String PARAMETER5_FOR_WORDS = "20";
    private static final String PARAMETER1_FOR_BYTES = "20";
    private static final String PARAMETER2_FOR_BYTES = "1";
    private static final String PARAMETER3_FOR_BYTES = "0";
    private static final String PARAMETER4_FOR_BYTES = "-1";
    private static final String WORDS1_RESULT = "10 words";
    private static final String WORDS2_RESULT = "5 words";
    private static final String WORDS3_RESULT = "5 words";
    private static final String WORDS4_RESULT = "5 words";
    private static final String WORDS5_RESULT = "20 words";
    private static final String BYTES1_RESULT = "20 bytes";
    private static final String BYTES2_RESULT = "3 bytes";
    private static final String BYTES3_RESULT = "5 bytes";
    private static final String BYTES4_RESULT = "5 bytes";


    @Test
    public void checkFirstResultOfGenerationWithWordsParameter() {
        getBusinessLogicLayer().sendKeysToInputFieldForGeneration(PARAMETER1_FOR_WORDS);
        getBusinessLogicLayer().chooseRadioButton(WORDS);
        getBusinessLogicLayer().clickGenerateLoremIpsumButton();
        assertTrue(getBusinessLogicLayer().getTextResult().contains(WORDS1_RESULT));
    }

    @Test
    public void checkSecondResultOfGenerationWithWordsParameter() {
        getBusinessLogicLayer().sendKeysToInputFieldForGeneration(PARAMETER2_FOR_WORDS);
        getBusinessLogicLayer().chooseRadioButton(WORDS);
        getBusinessLogicLayer().clickGenerateLoremIpsumButton();
        assertTrue(getBusinessLogicLayer().getTextResult().contains(WORDS2_RESULT));
    }

    @Test
    public void checkThirdResultOfGenerationWithWordsParameter() {
        getBusinessLogicLayer().sendKeysToInputFieldForGeneration(PARAMETER3_FOR_WORDS);
        getBusinessLogicLayer().chooseRadioButton(WORDS);
        getBusinessLogicLayer().clickGenerateLoremIpsumButton();
        assertTrue(getBusinessLogicLayer().getTextResult().contains(WORDS3_RESULT));
    }

    @Test
    public void checkFourthResultOfGenerationWithWordsParameter() {
        getBusinessLogicLayer().sendKeysToInputFieldForGeneration(PARAMETER4_FOR_WORDS);
        getBusinessLogicLayer().chooseRadioButton(WORDS);
        getBusinessLogicLayer().clickGenerateLoremIpsumButton();
        assertTrue(getBusinessLogicLayer().getTextResult().contains(WORDS4_RESULT));
    }

    @Test
    public void checkFifthResultOfGenerationWithWordsParameter() {
        getBusinessLogicLayer().sendKeysToInputFieldForGeneration(PARAMETER5_FOR_WORDS);
        getBusinessLogicLayer().chooseRadioButton(WORDS);
        getBusinessLogicLayer().clickGenerateLoremIpsumButton();
        assertTrue(getBusinessLogicLayer().getTextResult().contains(WORDS5_RESULT));
    }

    @Test
    public void checkFirstResultOfGenerationWithBytesParameter() {
        getBusinessLogicLayer().sendKeysToInputFieldForGeneration(PARAMETER1_FOR_BYTES);
        getBusinessLogicLayer().chooseRadioButton(BYTES);
        getBusinessLogicLayer().clickGenerateLoremIpsumButton();
        assertTrue(getBusinessLogicLayer().getTextResult().contains(BYTES1_RESULT));
    }

    @Test
    public void checkSecondResultOfGenerationWithBytesParameter() {
        getBusinessLogicLayer().sendKeysToInputFieldForGeneration(PARAMETER2_FOR_BYTES);
        getBusinessLogicLayer().chooseRadioButton(BYTES);
        getBusinessLogicLayer().clickGenerateLoremIpsumButton();
        assertTrue(getBusinessLogicLayer().getTextResult().contains(BYTES2_RESULT));
    }

    @Test
    public void checkThirdResultOfGenerationWithBytesParameter() {
        getBusinessLogicLayer().sendKeysToInputFieldForGeneration(PARAMETER3_FOR_BYTES);
        getBusinessLogicLayer().chooseRadioButton(BYTES);
        getBusinessLogicLayer().clickGenerateLoremIpsumButton();
        assertTrue(getBusinessLogicLayer().getTextResult().contains(BYTES3_RESULT));
    }

    @Test
    public void checkFourthResultOfGenerationWithBytesParameter() {
        getBusinessLogicLayer().sendKeysToInputFieldForGeneration(PARAMETER4_FOR_BYTES);
        getBusinessLogicLayer().chooseRadioButton(BYTES);
        getBusinessLogicLayer().clickGenerateLoremIpsumButton();
        assertTrue(getBusinessLogicLayer().getTextResult().contains(BYTES4_RESULT));
    }
}
