package level02.exercise02.assertions;

import level02.exercise02.model.ReferenceObjects;
import org.junit.jupiter.api.*;
import java.util.logging.Logger;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("ReferenceObjects - Unit Tests")
class ReferenceObjectsTest {

    private static final Logger log = Logger.getLogger(ReferenceObjectsTest.class.getName());

    private ReferenceObjects obj1, obj2, obj3;

    @BeforeAll
    static void beforeAll() {
        System.out.println(">>> Starting ReferenceObjects Test Suite...");
    }

    @AfterAll
    static void afterAll() {
        System.out.println(">>> ReferenceObjects Test Suite finished.");
    }

    @BeforeEach
    void setUp() {
        obj1 = new ReferenceObjects("Emiliano", 40);
        obj2 = new ReferenceObjects("Emiliano", 40);
        obj3 = obj1;
        log.info("New ReferenceObjects instances created.");
    }

    @AfterEach
    void tearDown() {
        log.info("Test completed.");
    }

    @Nested
    @DisplayName("Happy Path Tests")
    @Tag("happy")
    class HappyPath {

        @Test
        @DisplayName("Objects with same data but different references are not '=='")
        void shouldNotBeSameReference() {
            log.info("Comparing obj1 and obj2 for reference inequality...");
            assertNotSame(obj1, obj2, "Objects should not be the same reference");
        }

        @Test
        @DisplayName("Objects with same data are equal using equals()")
        void shouldBeEqualByContent() {
            log.info("Checking content equality between obj1 and obj2...");
            assertEquals(obj1, obj2, "Objects with same content should be equal");
        }

        @Test
        @DisplayName("Objects pointing to same reference are '=='")
        void shouldBeSameReference() {
            log.info("Comparing obj1 and obj3 for same reference...");
            assertSame(obj1, obj3, "Both variables should reference the same object");
        }

        @Test
        @DisplayName("Objects with different data are not equal")
        void shouldNotBeEqualByContent() {
            log.info("Comparing obj1 with a different object...");
            ReferenceObjects obj4 = new ReferenceObjects("Carlos", 25);
            assertNotEquals(obj1, obj4, "Objects with different data should not be equal");
        }
    }
}
