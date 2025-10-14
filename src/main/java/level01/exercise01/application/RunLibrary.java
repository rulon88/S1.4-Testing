package level01.exercise01.application;

import level01.exercise01.model.Book;
import level01.exercise01.model.Library;


public class RunLibrary {

    public static void run() {
        System.out.println("=== Library Execution Started ===");

        Library library = new Library();

        // Add books
        library.addBook(new Book("Clean Code", "Robert Martin", "111"));
        library.addBook(new Book("Effective Java", "Joshua Bloch", "123"));
        library.addBook(new Book("Refactoring", "Martin Fowler", "222"));

        // Show all
        System.out.println("\nBooks currently in library:");
        library.getBooks().forEach(System.out::println);

        // Remove one
        System.out.println("\nRemoving book with ISBN 123...");
        library.removeBook("123");

        // Show updated list
        System.out.println("\nBooks after removal:");
        library.getBooks().forEach(System.out::println);

        System.out.println("\n=== Execution Finished ===");
    }
}
