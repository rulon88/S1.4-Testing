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

            Library library = new Library();
            Book book = new Book("Refactoring", "Martin Fowler", "222");

            library.addBook(book);
            library.borrowBook("222");
            assertTrue(book.isBorrowed(), "Book should be marked as borrowed");

            library.returnBook("222");
            assertFalse(book.isBorrowed(), "Book should be marked as available again");
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
            @DisplayName("Should throw when borrowing twice via Library")
            void shouldThrowWhenBorrowingTwiceViaLibrary() {
                log.warning("Testing double borrow through Library...");
                Library library = new Library();
                Book book = new Book("Effective Java", "Joshua Bloch", "111");
                library.addBook(book);
                library.borrowBook("111");

                assertThrows(IllegalStateException.class, () -> library.borrowBook("111"));
            }

            @Test
            @DisplayName("Should throw when returning if not borrowed via Library")
            void shouldThrowWhenReturningIfNotBorrowedViaLibrary() {
                log.warning("Testing invalid return through Library...");
                Library library = new Library();
                Book book = new Book("Domain Driven Design", "Eric Evans", "333");
                library.addBook(book);

                assertThrows(IllegalStateException.class, () -> library.returnBook("333"));
            }
        }
    }
}
