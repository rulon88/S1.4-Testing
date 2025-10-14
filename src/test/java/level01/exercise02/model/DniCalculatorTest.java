package level01.exercise02.model;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import java.util.logging.Logger;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("DniCalculator - Unit Tests")
class DniCalculatorTest {

    private static final Logger log = Logger.getLogger(DniCalculatorTest.class.getName());
    private DniCalculator calculator;

    @BeforeAll
    static void beforeAll() {
        System.out.println(">>> Starting DniCalculator Test Suite...");
    }

    @AfterAll
    static void afterAll() {
        System.out.println(">>> DniCalculator Test Suite finished.");
    }

    @BeforeEach
    void setUp() {
        calculator = new DniCalculator();
        log.info("New DniCalculator instance created.");
    }

    @AfterEach
    void tearDown() {
        log.info("Test completed.\n");
    }

    @Nested
    @DisplayName("Happy Path Tests")
    @Tag("happy")
    class HappyPath {

        @ParameterizedTest
        @CsvSource({
                "0, T",
                "1, R",
                "2, W",
                "3, A",
                "99999999, R"
        })
        @DisplayName("Should return correct letter for valid DNI numbers")
        void shouldReturnCorrectLetter(int dni, char expectedLetter) {
            log.info("Testing valid DNI number: " + dni);
            char result = calculator.calculateLetter(dni);
            assertEquals(expectedLetter, result);
        }
    }

    @Nested
    @DisplayName("Bad Path Tests")
    @Tag("bad")
    class BadPath {

        @Test
        @DisplayName("Should throw exception for negative DNI number")
        void shouldThrowForNegativeNumber() {
            log.warning("Testing negative DNI...");
            assertThrows(IllegalArgumentException.class,
                    () -> calculator.calculateLetter(-1));
        }

        @Test
        @DisplayName("Should throw exception for number over 99,999,999")
        void shouldThrowForTooLargeNumber() {
            log.warning("Testing too large DNI...");
            assertThrows(IllegalArgumentException.class,
                    () -> calculator.calculateLetter(100_000_000));
        }
    }
}
