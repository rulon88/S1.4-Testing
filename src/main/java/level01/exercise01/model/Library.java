package level01.exercise01.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Library {

    private final List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        Validator.validateNotNull(book, "Book");

        if (books.contains(book))
            throw new IllegalArgumentException("Book already exists in the library");

        books.add(book);
        Collections.sort(books, (a, b) -> a.getTitle().compareToIgnoreCase(b.getTitle()));
    }

    public boolean removeBook(String isbn) {
        Validator.validateNotEmpty(isbn, "ISBN");
        return books.removeIf(book -> book.getIsbn().equalsIgnoreCase(isbn));
    }

    public Book getBookAt(int index) {
        if (index < 0 || index >= books.size())
            throw new IndexOutOfBoundsException("Invalid book index");
        return books.get(index);
    }

    public List<Book> getBooks() {
        return Collections.unmodifiableList(books);
    }

    public boolean isEmpty() {
        return books.isEmpty();
    }

    public void clearLibrary() {
        books.clear();
    }
}
