package kata;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringCalculatorKataTest {

    @Test
    void testEmptyString() {
        StringCalculatorKata calculator = new StringCalculatorKata();
        assertEquals(0, calculator.add(""));
    }

    @Test
    void testSingleNumbers() {
        StringCalculatorKata calculator = new StringCalculatorKata();
        assertEquals(1, calculator.add("1"));
    }

    @Test
    void testTwoNumbers() {
        StringCalculatorKata calculator = new StringCalculatorKata();
        assertEquals(3, calculator.add("1,2"));
    }

    @Test
    void testUnknownAmountOfNumbers() {
        StringCalculatorKata calculator = new StringCalculatorKata();
        assertEquals(6, calculator.add("1,2,3"));
    }

    @Test
    void testNewLinesBetweenNumbers() {
        StringCalculatorKata calculator = new StringCalculatorKata();
        assertEquals(6, calculator.add("1\n2,3"));
        assertEquals(6, calculator.add("1,2\n3"));
    }

    @Test
    void testCustomDelimiter() {
        StringCalculatorKata calculator = new StringCalculatorKata();
        assertEquals(3, calculator.add("//;\n1;2"));
    }

    @Test
    void testNegativeNumbers() {
        StringCalculatorKata calculator = new StringCalculatorKata();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                calculator.add("1,-2,3,-4"));
        assertEquals("negatives not allowed: [-2, -4]", exception.getMessage());
    }

    @Test
    void testIgnoreNumbersGreaterThan1000() {
        StringCalculatorKata calculator = new StringCalculatorKata();
        assertEquals(2, calculator.add("2,1001"));
    }

    @Test
    void testIgnoreNumbersGreaterThan1000WithDelimiter() {
        StringCalculatorKata calculator = new StringCalculatorKata();
        assertEquals(5, calculator.add("//;\n2;1001;3"));
    }
}
