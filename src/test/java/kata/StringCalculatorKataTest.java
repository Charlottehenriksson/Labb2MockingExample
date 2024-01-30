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
}
