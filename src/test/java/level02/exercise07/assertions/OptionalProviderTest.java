package level02.exercise07.assertions;

import level02.exercise07.model.OptionalProvider;
import org.junit.jupiter.api.*;
import java.util.Optional;
import java.util.logging.Logger;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("OptionalProvider - AssertJ Tests")
class OptionalProviderTest {

    private static final Logger log = Logger.getLogger(OptionalProviderTest.class.getName());
    private OptionalProvider provider;

    @BeforeAll
    static void beforeAll() {
        System.out.println(">>> Starting OptionalProvider Test Suite...");
    }

    @AfterAll
    static void afterAll() {
        System.out.println(">>> OptionalProvider Test Suite finished.");
    }

    @BeforeEach
    void setUp() {
        provider = new OptionalProvider();
        log.info("New OptionalProvider instance created.");
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
        @DisplayName("Should verify Optional is empty")
        void shouldVerifyOptionalIsEmpty() {
            log.info("Verifying empty Optional...");
            Optional<String> optional = provider.getEmptyOptional();
            assertThat(optional).isEmpty();
        }
    }

    @Nested
    @DisplayName("Bad Path Tests")
    @Tag("bad")
    class BadPath {
        @Test
        @DisplayName("Should verify Optional is not empty")
        void shouldVerifyOptionalIsNotEmpty() {
            log.warning("Verifying non-empty Optional...");
            Optional<String> optional = provider.getNonEmptyOptional();
            assertThat(optional).isNotEmpty()
                    .contains("Emiliano");
        }
    }
}
