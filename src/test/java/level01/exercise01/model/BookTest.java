package level01.exercise01.model;

import org.junit.jupiter.api.*;
import java.util.logging.Logger;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Book - Unit Tests")
class BookTest {

    private static final Logger log = Logger.getLogger(BookTest.class.getName());

    @BeforeAll
    static void beforeAll() {
        System.out.println(">>> Starting Book Test Suite...");
    }

    @AfterAll
    static void afterAll() {
        System.out.println(">>> Book Test Suite finished.");
    }



    @Nested
    @DisplayName("Happy Path Tests")
    @Tag("happy")
    class HappyPath {

        @Test
        @DisplayName("Should create valid book")
        void shouldCreateValidBook() {
            log.info("Creating a valid Book instance...");
            Book book = new Book("Clean Code", "Robert Martin", "111");
            assertEquals("Clean Code", book.getTitle());
            assertFalse(book.isBorrowed());
        }

        @Test
        @DisplayName("Should borrow and return correctly")
        void shouldBorrowAndReturn() {
            log.info("Borrowing and returning a book...");
            Book book = new Book("Refactoring", "Martin Fowler", "222");
            book.borrow();
            assertTrue(book.isBorrowed());
            book.returnBook();
            assertFalse(book.isBorrowed());
        }
    }




    @Nested
    @DisplayName("Bad Path Tests")
    @Tag("bad")
    class BadPath {

        @Test
        @DisplayName("Should throw for empty title")
        void shouldThrowForEmptyTitle() {
            log.warning("Testing empty title...");
            assertThrows(IllegalArgumentException.class,
                    () -> new Book("", "Author", "123"));
        }

        @Test
        @DisplayName("Should throw when borrowing twice")
        void shouldThrowWhenBorrowingTwice() {
            log.warning("Testing double borrow...");
            Book book = new Book("Effective Java", "Joshua Bloch", "111");
            book.borrow();
            assertThrows(IllegalStateException.class, book::borrow);
        }

        @Test
        @DisplayName("Should throw when returning if not borrowed")
        void shouldThrowWhenReturningIfNotBorrowed() {
            log.warning("Testing invalid return...");
            Book book = new Book("Domain Driven Design", "Eric Evans", "333");
            assertThrows(IllegalStateException.class, book::returnBook);
        }
    }
}
