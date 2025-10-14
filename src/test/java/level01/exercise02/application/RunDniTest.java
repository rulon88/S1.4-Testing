package level01.exercise02.application;

import org.junit.jupiter.api.*;
import java.util.logging.Logger;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("RunDni - Integration Test")
class RunDniTest {

    private static final Logger log = Logger.getLogger(RunDniTest.class.getName());

    @BeforeAll
    static void beforeAll() {
        System.out.println(">>> Starting RunDni Integration Test...");
    }

    @AfterAll
    static void afterAll() {
        System.out.println(">>> RunDni Integration Test finished.");
    }

    @Test
    @DisplayName("Happy Path - Should execute RunDni without exception")
    @Tag("happy")
    void shouldRunProgramSuccessfully() {
        log.info("Executing RunDni.run()...");
        assertDoesNotThrow(RunDni::run);
    }
}
