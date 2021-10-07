package tests;

import org.testng.annotations.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.testng.Assert.assertTrue;

public class NumberOfParagraphsWithKeywordTest extends BaseTest {
    private static final long DEFAULT_TIME = 120;
    private static final Double BOUNDARY_VALUE = 2d;
    private static final String KEYWORD = "lorem";
    private static Integer counterOfParagraphs = 0;

    @Test(priority = 1, invocationCount = 10)
    public void determiningNumberOfParagraphsThatContainsKeyword() {
        getBusinessLogicLayer().waitForPageLoadComplete(DEFAULT_TIME);
        getBusinessLogicLayer().clickGenerateLoremIpsumButton();
        getBusinessLogicLayer().waitForPageLoadComplete(DEFAULT_TIME);
        getBusinessLogicLayer().getParagraphs().stream().flatMap(x -> {
            if (x.getText().contains(KEYWORD)) {
                counterOfParagraphs++;
                return Stream.of(x);
            }
            return Stream.empty();
        }).collect(Collectors.toList());

    }

    @Test(priority = 2)
    public void checkCorrectnessOfAverageNumberOfParagraphsWithKeyword() {
        Double paragraphsWithWord = Double.valueOf(counterOfParagraphs);
        Double averageNumber = 50d / paragraphsWithWord;
        assertTrue(averageNumber >= BOUNDARY_VALUE);
    }
}
