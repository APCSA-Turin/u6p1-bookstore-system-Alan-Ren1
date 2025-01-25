package com.example.project;


public class BookStore {
    private Book[] books = new Book[10];
    private User[] users = new User[10];

    public BookStore() {
    }

    public User[] getUsers() {
        return users;
    }

    public void setUsers(User[] users) {
        this.users = users;
    }

    public Book[] getBooks() {
        int count = 0;
        for (Book book : books) {
            if (book != null) {
                count++;
            }
        }
    
        Book[] nonNullBooks = new Book[count];
        int index = 0;
        for (Book book : books) {
            if (book != null) {
                nonNullBooks[index++] = book;
            }
        }
    
        return nonNullBooks;
    }
    public void addUser(User user) {
        for (int i = 0; i < users.length; i++) {
            if (users[i] == null) {
                users[i] = user;
                return;
            }
        }
        System.out.println("User array is full!");
    }

    public void removeUser(User user) {
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null && users[i].equals(user)) {
                users[i] = null;
                consolidateUsers();
                return;
            }
        }
    }

    public void consolidateUsers() {
        User[] consolidated = new User[users.length];
        int index = 0;
        for (User user : users) {
            if (user != null) {
                consolidated[index++] = user;
            }
        }
        users = consolidated;
    }

    public void addBook(Book book) {
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) {
                books[i] = book;
                return;
            }
        }
        System.out.println("Book array is full!");
    }

    public void removeBook(Book book) {
        for (int i = 0; i < books.length; i++) {
            if (books[i] != null && books[i].equals(book)) {
                if (books[i].getQuantity() > 1) {
                    books[i].decrementQuantity();
                } else {
                    books[i] = null;
                    consolidateBooks();
                }
                return;
            }
        }
    }

    public void consolidateBooks() {
        Book[] consolidated = new Book[books.length];
        int index = 0;
        for (Book book : books) {
            if (book != null) {
                consolidated[index++] = book;
            }
        }
        books = consolidated;
    }

    public void insertBook(Book book, int index) {
        if (index >= 0 && index < books.length) {
            if (books[index] == null) {
                books[index] = book; // Place the book if the index is empty
            } else {
                // Shift the existing books to make room for the new book
                for (int i = books.length - 1; i > index; i--) {
                    books[i] = books[i - 1];
                }
                books[index] = book;
            }
        } else {
            System.out.println("Invalid index!");
        }
    }    
}
    


   // public String bookStoreBookInfo(){} //you are not tested on this method but use it for debugging purposes


    // public String bookStoreUserInfo(){} //you are not tested on this method but use it for debugging purposes