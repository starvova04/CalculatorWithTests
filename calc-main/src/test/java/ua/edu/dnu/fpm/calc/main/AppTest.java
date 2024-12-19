package ua.edu.dnu.fpm.calc.main;

import org.junit.jupiter.api.Test;

public class AppTest {

    @Test
    void shouldRunApplicationWithoutErrors() {
        // GIVEN
        String[] args = {"10", "5", "+"};

        // WHEN & THEN
        App.main(args);
    }

    @Test
    void shouldHandleInvalidOperator() {
        // GIVEN
        String[] args = {"10", "5", "invalidOperator"};

        // WHEN & THEN
        App.main(args);
    }

    @Test
    void shouldHandleInsufficientArguments() {
        // GIVEN
        String[] args = {"10"};

        // WHEN & THEN
        App.main(args);
    }

    @Test
    void shouldHandleDivisionByZero() {
        // GIVEN
        String[] args = {"10", "0", "/"};

        // WHEN & THEN
        App.main(args);
    }
}
