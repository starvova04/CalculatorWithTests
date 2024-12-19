package ua.edu.dnu.fpm.calc.core;
import org.junit.jupiter.api.Test;
import ua.edu.dnu.fpm.calc.api.Calc;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalcTest {

    private final Calc calc = new CalcImpl();

    @Test
    void shouldAddTwoNumbers() {
        // GIVEN
        double a = 5.0;
        double b = 3.0;

        // WHEN
        double result = calc.addition(a, b);

        // THEN
        assertThat(result, is(8.0));
    }

    @Test
    void shouldSubtractTwoNumbers() {
        // GIVEN
        double a = 10.0;
        double b = 7.0;

        // WHEN
        double result = calc.subtraction(a, b);

        // THEN
        assertThat(result, is(3.0));
    }

    @Test
    void shouldMultiplyTwoNumbers() {
        // GIVEN
        double a = 4.0;
        double b = 5.0;

        // WHEN
        double result = calc.multiplication(a, b);

        // THEN
        assertThat(result, is(20.0));
    }

    @Test
    void shouldDivideTwoNumbers() {
        // GIVEN
        double a = 20.0;
        double b = 4.0;

        // WHEN
        double result = calc.division(a, b);

        // THEN
        assertThat(result, is(5.0));
    }

    @Test
    void shouldThrowExceptionWhenDivideByZero() {
        // GIVEN
        double a = 5.0;
        double b = 0.0;

        // WHEN & THEN
        assertThrows(ArithmeticException.class, () -> calc.division(a, b));
    }

    @Test
    void shouldProcessTaskCorrectly() {
        // GIVEN
        String[] args = {"12", "34", "+", "45", "-5"};

        // WHEN
        String result = calc.task(args);

        // THEN
        assertThat(result.contains("Total args: 5"), is(true));
        assertThat(result.contains("Number args: 4"), is(true));
        assertThat(result.contains("Max number: 45"), is(true));
    }
}
