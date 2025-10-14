package level01.exercise01.model;

import java.util.Objects;

public class Book {

    private final String title;
    private final String author;
    private final String isbn;
    private boolean borrowed;

    public Book(String title, String author, String isbn) {
        Validator.validateNotEmpty(title, "Title");
        Validator.validateNotEmpty(author, "Author");
        Validator.validateNotEmpty(isbn, "ISBN");

        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.borrowed = false;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getIsbn() { return isbn; }
    public boolean isBorrowed() { return borrowed; }

    public void borrow() {
        if (borrowed)
            throw new IllegalStateException("Book is already borrowed");
        borrowed = true;
    }

    public void returnBook() {
        if (!borrowed)
            throw new IllegalStateException("Book was not borrowed");
        borrowed = false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return isbn.equalsIgnoreCase(book.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn.toLowerCase());
    }

    @Override
    public String toString() {
        return String.format("%s by %s (ISBN: %s)", title, author, isbn);
    }
}
