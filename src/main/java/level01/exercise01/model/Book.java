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


    void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o.getClass() != Book.class) return false;
        Book book = (Book) o;
        return isbn.equalsIgnoreCase(book.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn.toLowerCase());
    }

    @Override
    public String toString() {
        return String.format("%s by %s [%s] %s",
                title, author, isbn,
                borrowed ? "(Borrowed)" : "(Available)");
    }
}
