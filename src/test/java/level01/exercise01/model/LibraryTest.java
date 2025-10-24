package level01.exercise01.model;

import org.junit.jupiter.api.*;
import java.util.List;
import java.util.logging.Logger;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Library - Unit Tests")
class LibraryTest {

    private static final Logger log = Logger.getLogger(LibraryTest.class.getName());
    private Library library;
    private Book book1, book2, duplicateBook;

    @BeforeAll
    static void beforeAll() {
        System.out.println(">>> Starting Library Test Suite...");
    }

    @AfterAll
    static void afterAll() {
        System.out.println(">>> Library Test Suite finished.");
    }

    @BeforeEach
    void setUp() {
        library = new Library();
        book1 = new Book("Clean Code", "Robert Martin", "111");
        book2 = new Book("Effective Java", "Joshua Bloch", "222");
        duplicateBook = new Book("Clean Code", "Robert Martin", "111");
        log.info("Initialized new Library instance for test.");
    }

    @AfterEach
    void tearDown() {
        log.info("Library test completed.");
        library = null;
    }

    @Nested
    @DisplayName("Happy Path Tests")
    @Tag("happy")
    class HappyPath {

        @Test
        @DisplayName("Should add and sort books alphabetically")
        void shouldAddAndSortBooks() {
            log.info("Adding books to library...");
            library.addBook(book2);
            library.addBook(book1);
            List<Book> books = library.getBooks();
            assertEquals(2, books.size());
            assertEquals("Clean Code", books.get(0).getTitle());
        }

        @Test
        @DisplayName("Should remove an existing book")
        void shouldRemoveExistingBook() {
            log.info("Removing existing book...");
            library.addBook(book1);
            library.addBook(book2);
            boolean removed = library.removeBook("111");
            assertTrue(removed);
        }

        @Test
        @DisplayName("Should get a book by valid index")
        void shouldGetBookByValidIndex() {
            log.info("Getting book by index...");
            library.addBook(book1);
            assertEquals("Clean Code", library.getBookAt(0).getTitle());
        }

        @Test
        @DisplayName("Should borrow and return a book successfully")
        void shouldBorrowAndReturnBook() {
            log.info("Testing borrow and return flow...");
            library.addBook(book1);

            library.borrowBook("111");
            assertTrue(book1.isBorrowed(), "Book should be borrowed");

            library.returnBook("111");
            assertFalse(book1.isBorrowed(), "Book should be available again");
        }
    }

    @Nested
    @DisplayName("Bad Path Tests")
    @Tag("bad")
    class BadPath {

        @Test
        @DisplayName("Should throw when adding duplicate book")
        void shouldThrowWhenAddingDuplicateBook() {
            log.warning("Testing duplicate book addition...");
            library.addBook(book1);
            assertThrows(IllegalArgumentException.class, () -> library.addBook(duplicateBook));
        }

        @Test
        @DisplayName("Should throw for invalid index")
        void shouldThrowForInvalidIndex() {
            log.warning("Testing invalid index...");
            library.addBook(book1);
            assertThrows(IndexOutOfBoundsException.class, () -> library.getBookAt(5));
        }

        @Test
        @DisplayName("Should return false when removing non-existent book")
        void shouldReturnFalseWhenRemovingNonExistentBook() {
            log.warning("Testing removal of non-existent book...");
            library.addBook(book1);
            assertFalse(library.removeBook("999"));
        }

        @Test
        @DisplayName("Should throw when borrowing an already borrowed book")
        void shouldThrowWhenBorrowingAlreadyBorrowedBook() {
            log.warning("Testing double borrow...");
            library.addBook(book1);
            library.borrowBook("111");
            assertThrows(IllegalStateException.class, () -> library.borrowBook("111"));
        }

        @Test
        @DisplayName("Should throw when returning a book that was not borrowed")
        void shouldThrowWhenReturningBookNotBorrowed() {
            log.warning("Testing invalid return...");
            library.addBook(book1);
            assertThrows(IllegalStateException.class, () -> library.returnBook("111"));
        }
    }
}
