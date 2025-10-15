package level02.exercise05.assertions;

import org.junit.jupiter.api.*;
import java.util.*;
import java.util.logging.Logger;
import level02.exercise05.model.CountryMapContainer;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("CountryMapContainer - AssertJ Tests")
class CountryMapContainerTest {

    private static final Logger log = Logger.getLogger(CountryMapContainerTest.class.getName());
    private CountryMapContainer container;

    @BeforeAll
    static void beforeAll() {
        System.out.println(">>> Starting CountryMapContainer Test Suite...");
    }

    @AfterAll
    static void afterAll() {
        System.out.println(">>> CountryMapContainer Test Suite finished.");
    }

    @BeforeEach
    void setUp() {
        container = new CountryMapContainer();
        log.info("New CountryMapContainer instance created.");
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
        @DisplayName("Should verify map contains a specific key and entry")
        void shouldVerifyMapContainsKeyAndEntry() {
            log.info("Verifying map contains key and entry...");
            Map<String, String> countries = container.getCountryMap();
            assertThat(countries)
                    .containsKey("ES")
                    .containsEntry("FR", "France")
                    .hasSize(3);
        }
    }

    @Nested
    @DisplayName("Bad Path Tests")
    @Tag("bad")
    class BadPath {
        @Test
        @DisplayName("Should verify map does not contain invalid key")
        void shouldVerifyMapDoesNotContainInvalidKey() {
            log.warning("Verifying missing key in map...");
            Map<String, String> countries = container.getCountryMap();
            assertThat(countries).doesNotContainKey("IT");
        }
    }
}
