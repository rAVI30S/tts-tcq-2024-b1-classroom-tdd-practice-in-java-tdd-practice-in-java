package TddPracticeInJava;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class StringCalculatorTest {

    @Test
    public void testEmptyString() {
        int expectedResult = 0;
        String input = "";
        StringCalculator objUnderTest = new StringCalculator();
        int result = objUnderTest.add(input);
        assertEquals(expectedResult, result);
    }

    @Test
    public void testSingleNumber() {
        int expectedResult = 1;
        String input = "1";
        StringCalculator objUnderTest = new StringCalculator();
        int result = objUnderTest.add(input);
        assertEquals(expectedResult, result);
    }

    @Test
    public void testTwoNumbers() {
        int expectedResult = 3;
        String input = "1,2";
        StringCalculator objUnderTest = new StringCalculator();
        int result = objUnderTest.add(input);
        assertEquals(expectedResult, result);
    }

    @Test
    public void testNewLinesBetweenNumbers() {
        int expectedResult = 6;
        String input = "1\n2,3";
        StringCalculator objUnderTest = new StringCalculator();
        int result = objUnderTest.add(input);
        assertEquals(expectedResult, result);
    }

    @Test
    public void testDifferentDelimiter() {
        int expectedResult = 3;
        String input = "//;\n1;2";
        StringCalculator objUnderTest = new StringCalculator();
        int result = objUnderTest.add(input);
        assertEquals(expectedResult, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeNumbers() {
        String input = "-1,2,-3";
        StringCalculator objUnderTest = new StringCalculator();
        objUnderTest.add(input);
    }

    @Test
    public void testIgnoreNumbersGreaterThan1000() {
        int expectedResult = 2;
        String input = "2,1001";
        StringCalculator objUnderTest = new StringCalculator();
        int result = objUnderTest.add(input);
        assertEquals(expectedResult, result);
    }

    @Test
    public void testDelimiterOfAnyLength() {
        int expectedResult = 6;
        String input = "//[***]\n1***2***3";
        StringCalculator objUnderTest = new StringCalculator();
        int result = objUnderTest.add(input);
        assertEquals(expectedResult, result);
    }
}
