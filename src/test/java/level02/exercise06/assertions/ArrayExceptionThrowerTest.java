package level02.exercise06.assertions;

import org.junit.jupiter.api.*;
import java.util.logging.Logger;
import level02.exercise06.model.ArrayExceptionThrower;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("ArrayExceptionThrower - AssertJ Exception Tests")
class ArrayExceptionThrowerTest {

    private static final Logger log = Logger.getLogger(ArrayExceptionThrowerTest.class.getName());
    private ArrayExceptionThrower thrower;

    @BeforeAll
    static void beforeAll() {
        System.out.println(">>> Starting ArrayExceptionThrower Test Suite...");
    }

    @AfterAll
    static void afterAll() {
        System.out.println(">>> ArrayExceptionThrower Test Suite finished.");
    }

    @BeforeEach
    void setUp() {
        thrower = new ArrayExceptionThrower();
        log.info("New ArrayExceptionThrower instance created.");
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
        @DisplayName("Should verify ArrayIndexOutOfBoundsException is thrown")
        void shouldVerifyExceptionIsThrown() {
            log.info("Verifying ArrayIndexOutOfBoundsException...");
            assertThatThrownBy(() -> thrower.throwException())
                    .isInstanceOf(ArrayIndexOutOfBoundsException.class)
                    .hasMessageContaining("Index");
        }
    }

    @Nested
    @DisplayName("Bad Path Tests")
    @Tag("bad")
    class BadPath {
        @Test
        @DisplayName("Should not throw other exceptions")
        void shouldNotThrowDifferentException() {
            log.warning("Verifying no other exception is thrown...");
            assertThatThrownBy(() -> thrower.throwException())
                    .isNotInstanceOf(NullPointerException.class);
        }
    }
}
