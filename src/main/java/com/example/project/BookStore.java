package com.example.project;

public class BookStore {
    private Book[] books = new Book[10]; // Array to store books in the store
    private User[] users = new User[10]; // Array to store users of the store

    public BookStore() {
    }

    // Getter method to retrieve all users in the store
    public User[] getUsers() {
        return users;
    }

    // Setter method to set users array
    public void setUsers(User[] users) {
        this.users = users;
    }

    // Getter method to retrieve only non-null books in the store
    public Book[] getBooks() {
        int count = 0;
        // Count how many books are not null in the books array
        for (Book book : books) {
            if (book != null) {
                count++;
            }
        }

        // Create a new array to store non-null books
        Book[] nonNullBooks = new Book[count];
        int index = 0;
        for (Book book : books) {
            if (book != null) {
                nonNullBooks[index++] = book; // Populate the new array with non-null books
            }
        }

        return nonNullBooks;
    }

    // Add a user to the store
    public void addUser(User user) {
        for (int i = 0; i < users.length; i++) {
            if (users[i] == null) {
                users[i] = user; // Place the user in the first empty slot
                return;
            }
        }
        System.out.println("User array is full!"); // Print a message if there's no space for the new user
    }

    // Remove a user from the store
    public void removeUser(User user) {
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null && users[i].equals(user)) {
                users[i] = null; // Set the user to null to remove it
                consolidateUsers(); // Reorganize the users array to eliminate gaps
                return;
            }
        }
    }

    // Reorganize the users array to eliminate null values and fill gaps
    public void consolidateUsers() {
        User[] consolidated = new User[users.length];
        int index = 0;
        for (User user : users) {
            if (user != null) {
                consolidated[index++] = user; // Copy non-null users into the new array
            }
        }
        users = consolidated; // Replace the original users array with the consolidated one
    }

    // Add a book to the store
    public void addBook(Book book) {
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) {
                books[i] = book; // Place the book in the first empty slot
                return;
            }
        }
        System.out.println("Book array is full!"); // Print a message if there's no space for the new book
    }

    // Remove a book from the store
    public void removeBook(Book book) {
        for (int i = 0; i < books.length; i++) {
            if (books[i] != null && books[i].equals(book)) {
                if (books[i].getQuantity() > 1) {
                    books[i].decrementQuantity(); // Decrease quantity if more than 1
                } else {
                    books[i] = null; // Remove the book if quantity is 1
                    consolidateBooks(); // Reorganize the books array to eliminate gaps
                }
                return;
            }
        }
    }

    // Reorganize the books array to eliminate null values and fill gaps
    public void consolidateBooks() {
        Book[] consolidated = new Book[books.length];
        int index = 0;
        for (Book book : books) {
            if (book != null) {
                consolidated[index++] = book; // Copy non-null books into the new array
            }
        }
        books = consolidated; // Replace the original books array with the consolidated one
    }

    // Insert a book at a specific index in the books array
    public void insertBook(Book book, int index) {
        if (index >= 0 && index < books.length) {
            if (books[index] == null) {
                books[index] = book; // Place the book if the index is empty
            } else {
                // Shift the existing books to make room for the new book at the specified index
                for (int i = books.length - 1; i > index; i--) {
                    books[i] = books[i - 1]; // Move each book one position to the right
                }
                books[index] = book; // Insert the book at the specified index
            }
        } else {
            System.out.println("Invalid index!"); // Print an error message if the index is out of bounds
        }
    }    
}



   // public String bookStoreBookInfo(){} //you are not tested on this method but use it for debugging purposes


    // public String bookStoreUserInfo(){} //you are not tested on this method but use it for debugging purposes