package com.example.project;

public class User {

    // Instance variables
    private String name; // Name of the user
    private String Id; // Unique ID of the user
    private Book[] books; // Array to store books assigned to the user (maximum of 5 books)

    // Constructor to initialize the user with a name and ID
    public User(String name, String Id) {
        this.name = name; // Assigning the provided name
        this.Id = Id; // Assigning the provided ID
        this.books = new Book[5]; // Initializes an array of size 5 to store books
        for (int i = 0; i < books.length; i++) {
            books[i] = null; // Initialize all slots in the books array to null
        }
    }

    // Getter for the user's name
    public String getName() {
        return name;
    }

    // Setter for the user's name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for the user's ID
    public String getId() {
        return Id;
    }

    // Setter for the user's ID
    public void setId(String Id) {
        this.Id = Id;
    }

    // Getter for the user's books
    public Book[] getBooks() {
        return books;
    }

    // Setter for the user's books array. Ensures that only a valid array of exactly 5 books is set.
    public void setBooks(Book[] books) {
        if (books != null && books.length == 5) {
            this.books = books; // Only set the books array if it contains exactly 5 elements
        } else {
            System.out.println("Books array must have exactly 5 elements.");
        }
    }

    // Method to get the information about all books the user currently has
    public String bookListInfo() {
        StringBuilder bookList = new StringBuilder(); // Use StringBuilder for string concatenation
        for (Book book : books) {
            if (book == null) {
                bookList.append("empty\n"); // If the book slot is empty, append "empty" to the list
            } else {
                bookList.append(book.bookInfo()).append("\n"); // Append the book's information 
            }
        }
        return bookList.toString(); // Return the compiled list of book information
    }

    // Method to return detailed user information including name, ID, and books they have
    public String userInfo() {
        return "Name: " + name + "\nId: " + Id + "\nBooks: \n" + bookListInfo();
    }
}
