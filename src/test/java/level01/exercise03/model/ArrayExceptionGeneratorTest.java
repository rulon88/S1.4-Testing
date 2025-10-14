package level01.exercise03.model;

import org.junit.jupiter.api.*;
import java.util.logging.Logger;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("ArrayExceptionGenerator - JUnit Tests")
class ArrayExceptionGeneratorTest {

    private static final Logger log = Logger.getLogger(ArrayExceptionGeneratorTest.class.getName());
    private ArrayExceptionGenerator generator;

    @BeforeAll
    static void beforeAll() {
        System.out.println(">>> Starting ArrayExceptionGenerator Test Suite...");
    }

    @AfterAll
    static void afterAll() {
        System.out.println(">>> ArrayExceptionGenerator Test Suite finished.");
    }

    @BeforeEach
    void setUp() {
        generator = new ArrayExceptionGenerator();
        log.info("New ArrayExceptionGenerator instance created.");
    }

    @AfterEach
    void tearDown() {
        log.info("Test completed.\n");
    }

    @Nested
    @DisplayName("Happy Path Tests")
    @Tag("happy")
    class HappyPath {

        @Test
        @DisplayName("Should throw ArrayIndexOutOfBoundsException when accessing invalid index")
        void shouldThrowArrayIndexOutOfBounds() {
            log.info("Testing ArrayIndexOutOfBoundsException...");
            assertThrows(ArrayIndexOutOfBoundsException.class, generator::generateException);
        }
    }

    @Nested
    @DisplayName("Bad Path Tests")
    @Tag("bad")
    class BadPath {

        @Test
        @DisplayName("Should not throw other exceptions")
        void shouldNotThrowOtherExceptions() {
            log.warning("Ensuring no other exception is thrown...");
            assertDoesNotThrow(() -> {
                try {
                    generator.generateException();
                } catch (ArrayIndexOutOfBoundsException e) {
                    // expected behavior
                }
            });
        }
    }
}
