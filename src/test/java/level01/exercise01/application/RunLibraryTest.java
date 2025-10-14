package level01.exercise01.application;

import org.junit.jupiter.api.*;
import java.util.logging.Logger;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("RunLibrary - Integration Test")
class RunLibraryTest {

    private static final Logger log = Logger.getLogger(RunLibraryTest.class.getName());

    @BeforeAll
    static void beforeAll() {
        System.out.println(">>> Starting RunLibrary Integration Test...");
    }

    @AfterAll
    static void afterAll() {
        System.out.println(">>> RunLibrary Integration Test finished.");
    }

    @Test
    @DisplayName(" Should execute the program without exceptions")
    @Tag("happy")
    void shouldRunProgramSuccessfully() {
        log.info("Executing RunLibrary...");
        assertDoesNotThrow(RunLibrary::run);
    }
}
