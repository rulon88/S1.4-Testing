package level03.exercise01.assertions;

import level03.exercise01.model.Calculator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import java.util.logging.Logger;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Calculator - TDD Refactored Tests")
class CalculatorTest {

    private static final Logger log = Logger.getLogger(CalculatorTest.class.getName());
    private Calculator calculator;

    @BeforeAll
    static void beforeAll() {
        System.out.println(">>> Starting Calculator Test Suite...");
    }

    @AfterAll
    static void afterAll() {
        System.out.println(">>> Calculator Test Suite finished.");
    }

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
        logInstance("Created new Calculator instance.");
    }

    @AfterEach
    void tearDown() {
        logInstance("Test completed.\n");
    }

    private void logInstance(String message) {
        log.info(message);
    }

    @Nested
    @DisplayName("Happy Path")
    @Tag("happy")
    class HappyPath {

        @ParameterizedTest
        @CsvSource({
                "2,3,5",
                "-1,1,0",
                "1.5,2.5,4.0"
        })
        @DisplayName("Given a calculator, when adding numbers, then result is correct")
        void shouldAddNumbers(double a, double b, double expected) {
            logInstance("Testing addition...");
            double result = calculator.add(a, b);
            assertThat(result).isEqualTo(expected);
        }

        @ParameterizedTest
        @CsvSource({
                "5,3,2",
                "2,5,-3",
                "3.5,1.2,2.3"
        })
        @DisplayName("Given a calculator, when subtracting numbers, then result is correct")
        void shouldSubtractNumbers(double a, double b, double expected) {
            logInstance("Testing subtraction...");
            double result = calculator.subtract(a, b);
            assertThat(result).isEqualTo(expected);
        }

        @ParameterizedTest
        @CsvSource({
                "2,3,6",
                "-2,3,-6",
                "1.5,2,3.0"
        })
        @DisplayName("Given a calculator, when multiplying numbers, then result is correct")
        void shouldMultiplyNumbers(double a, double b, double expected) {
            logInstance("Testing multiplication...");
            double result = calculator.multiply(a, b);
            assertThat(result).isEqualTo(expected);
        }

        @ParameterizedTest
        @CsvSource({
                "6,3,2",
                "-6,3,-2",
                "7.5,2.5,3.0",
                "0,5,0"
        })
        @DisplayName("Given a calculator, when dividing numbers, then result is correct")
        void shouldDivideNumbers(double a, double b, double expected) {
            logInstance("Testing division...");
            double result = calculator.divide(a, b);
            assertThat(result).isEqualTo(expected);
        }
    }

    @Nested
    @DisplayName("Bad Path")
    @Tag("bad")
    class BadPath {

        @Test
        @DisplayName("Given a calculator, when dividing by zero, then an exception is thrown")
        void shouldThrowWhenDividingByZero() {
            logInstance("Testing division by zero...");
            assertThrows(IllegalArgumentException.class, () -> calculator.divide(10, 0));
        }
    }
}
