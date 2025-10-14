package level02.exercise04.assertions;

import org.junit.jupiter.api.*;
import java.util.*;
import java.util.logging.Logger;
import level02.exercise04.model.*;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("MixedListContainer - AssertJ Tests")
class MixedListContainerTest {

    private static final Logger log = Logger.getLogger(MixedListContainerTest.class.getName());
    private MixedListContainer container;

    @BeforeAll
    static void beforeAll() {
        System.out.println(">>> Starting MixedListContainer Test Suite...");
    }

    @AfterAll
    static void afterAll() {
        System.out.println(">>> MixedListContainer Test Suite finished.");
    }

    @BeforeEach
    void setUp() {
        container = new MixedListContainer();
        log.info("New MixedListContainer instance created.");
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
        @DisplayName("Should verify objects are in the same order of insertion")
        void shouldVerifyOrderOfInsertion() {
            log.info("Verifying insertion order...");
            List<Object> list = container.getMixedList();
            assertThat(list).extracting(Object::toString)
                    .containsExactly("Clean Code", "Tesla", "Emiliano");
        }

        @Test
        @DisplayName("Should verify list contains objects in any order")
        void shouldVerifyContainsInAnyOrder() {
            log.info("Verifying list contains all elements regardless of order...");
            List<Object> list = container.getMixedList();
            assertThat(list).extracting(Object::toString)
                    .contains("Tesla", "Clean Code", "Emiliano");
        }

        @Test
        @DisplayName("Should verify there are no duplicate elements")
        void shouldVerifyNoDuplicates() {
            log.info("Verifying no duplicates in list...");
            List<Object> list = container.getMixedList();
            assertThat(list).doesNotHaveDuplicates();
        }

        @Test
        @DisplayName("Should verify list does not contain missing element")
        void shouldVerifyMissingElement() {
            log.info("Verifying missing element...");
            List<Object> list = container.getMixedList();
            assertThat(list).extracting(Object::toString)
                    .doesNotContain("Refactoring");
        }
    }
}
