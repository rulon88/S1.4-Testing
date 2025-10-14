package level02.excercise01.assertions;

import level02.exercise01.model.IntegerValues;
import org.junit.jupiter.api.*;

import java.util.logging.Logger;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("IntegerValues - AssertJ Tests")
class IntegerValuesTest {

    private static final Logger log = Logger.getLogger(IntegerValuesTest.class.getName());
    private IntegerValues values;

    @BeforeAll
    static void beforeAll() {
        System.out.println(">>> Starting IntegerValues Test Suite...");
    }

    @AfterAll
    static void afterAll() {
        System.out.println(">>> IntegerValues Test Suite finished.");
    }

    @BeforeEach
    void setUp() {
        values = new IntegerValues();
        log.info("New IntegerValues instance created.");
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
        @DisplayName("Should verify equal and not equal integers")
        void shouldVerifyEqualAndNotEqual() {
            log.info("Verifying integer equality and difference...");
            assertThat(values.areEqual(10, 10)).isTrue();
            assertThat(values.areNotEqual(10, 25)).isTrue();
        }
    }

    @Nested
    @DisplayName("Bad Path Tests")
    @Tag("bad")
    class BadPath {
        @Test
        @DisplayName("Should handle null values properly")
        void shouldHandleNullValuesProperly() {
            log.warning("Testing null handling...");
            assertThat(values.areEqual(null, 5)).isFalse();
            assertThat(values.areNotEqual(null, 5)).isTrue();
        }
    }
}
