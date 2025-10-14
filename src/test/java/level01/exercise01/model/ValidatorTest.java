package level01.exercise01.model;

import org.junit.jupiter.api.*;
import java.util.logging.Logger;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Validator - Unit Tests")
class ValidatorTest {

    private static final Logger log = Logger.getLogger(ValidatorTest.class.getName());



    @Nested
    @DisplayName("Happy Path Tests")
    @Tag("happy")
    class HappyPath {

        @Test
        @DisplayName("Should not throw for valid string")
        void shouldNotThrowForValidString() {
            log.info("Validating non-empty string...");
            assertDoesNotThrow(() -> Validator.validateNotEmpty("Valid", "Title"));
        }

        @Test
        @DisplayName("Should not throw for valid object")
        void shouldNotThrowForValidObject() {
            log.info("Validating non-null object...");
            assertDoesNotThrow(() -> Validator.validateNotNull(new Object(), "Book"));
        }
    }




    @Nested
    @DisplayName("Bad Path Tests")
    @Tag("bad")
    class BadPath {

        @Test
        @DisplayName("Should throw for empty string")
        void shouldThrowForEmptyString() {
            log.warning("Testing empty string...");
            assertThrows(IllegalArgumentException.class, () -> Validator.validateNotEmpty("", "Title"));
        }

        @Test
        @DisplayName("Should throw for null string")
        void shouldThrowForNullString() {
            log.warning("Testing null string...");
            assertThrows(IllegalArgumentException.class, () -> Validator.validateNotEmpty(null, "Title"));
        }

        @Test
        @DisplayName("Should throw for null object")
        void shouldThrowForNullObject() {
            log.warning("Testing null object...");
            assertThrows(IllegalArgumentException.class, () -> Validator.validateNotNull(null, "Book"));
        }
    }
}
