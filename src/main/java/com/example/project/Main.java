package com.example.project;

public class Main {
    public static void main(String[] args) {
        // Create a BookStore instance
        BookStore store = new BookStore();

        // Create Book objects
        Book b1 = new Book("The Great Gatsby", "Scott Fitzgerald", 1925, "979-8351145013", 3);
        Book b2 = new Book("The Outliers", "Malcolm Gladwell", 2008, "978-0316017930", 1);
        Book b3 = new Book("1984", "George Orwell", 1949, "978-0451524935", 5);
        Book b4 = new Book("Brave New World", "Aldous Huxley", 1932, "978-0060850524", 3);
        Book b5 = new Book("Test", "Author", 1900, "1234", 1);

        // Add and insert books
        store.addBook(b1); // Add b1 to index 0
        store.addBook(b4); // Add b4 to index 1
        store.insertBook(b2, 1); // Insert b2 into index 1 (overwrites b4)
        store.insertBook(b3, 2); // Insert b3 into index 2
        store.insertBook(b5, 4); // Insert b5 into index 4

        // Fetch all books
        Book[] books = store.getBooks();

        // Expected books
        Book[] expected = {b1, b2, b3, b4, b5, null, null, null, null, null};

        // Print and verify results
        System.out.println("Books in store:");
        for (int i = 0; i < books.length; i++) {
            if (books[i] != null) {
                System.out.println("Index " + i + ": " + books[i].bookInfo());
            } else {
                System.out.println("Index " + i + ": null");
            }
        }

        // Manual assertion for verification
        boolean testPassed = true;
        for (int i = 0; i < books.length; i++) {
            if (books[i] != expected[i]) {
                testPassed = false;
                System.out.println("Test failed at index " + i + ": expected " +
                        (expected[i] == null ? "null" : expected[i].bookInfo()) +
                        ", but got " +
                        (books[i] == null ? "null" : books[i].bookInfo()));
            }
        }

        // Display final test result
        if (testPassed) {
            System.out.println("\nAll test cases passed!");
        } else {
            System.out.println("\nSome test cases failed.");
        }
    }
}
