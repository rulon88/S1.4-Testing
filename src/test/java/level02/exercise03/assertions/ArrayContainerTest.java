package level02.exercise03.assertions;

import org.junit.jupiter.api.*;
import java.util.logging.Logger;
import level02.exercise03.model.ArrayContainer;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("ArrayContainer - AssertJ Tests")
class ArrayContainerTest {

    private static final Logger log = Logger.getLogger(ArrayContainerTest.class.getName());
    private ArrayContainer container;

    @BeforeAll
    static void beforeAll() {
        System.out.println(">>> Starting ArrayContainer Test Suite...");
    }

    @AfterAll
    static void afterAll() {
        System.out.println(">>> ArrayContainer Test Suite finished.");
    }

    @BeforeEach
    void setUp() {
        container = new ArrayContainer();
        log.info("New ArrayContainer instance created.");
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
        @DisplayName("Should verify that two arrays are identical")
        void shouldVerifyIdenticalArrays() {
            log.info("Verifying identical arrays...");
            int[] expected = {1, 2, 3};
            assertThat(container.getArray()).containsExactly(expected);
        }
    }

    @Nested
    @DisplayName("Bad Path Tests")
    @Tag("bad")
    class BadPath {
        @Test
        @DisplayName("Should detect arrays with different elements")
        void shouldDetectDifferentArrays() {
            log.warning("Verifying different arrays...");
            int[] different = {1, 3, 2};
            assertThat(container.getArray()).isNotEqualTo(different);
        }
    }
}
