package com.example.project;

import java.util.Scanner;

public class BookStoreInterface {
    private static final BookStore store = new BookStore();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            showMenu();
            int choice = getUserChoice();

            switch (choice) {
                case 1 -> addBookToStore();
                case 2 -> removeBookFromStore();
                case 3 -> viewBooksInStore();
                case 4 -> addUserToStore();
                case 5 -> removeUserFromStore();
                case 6 -> viewUsers();
                case 7 -> {
                    System.out.println("\nThank you for using the BookStore. Exiting...");
                    scanner.close();
                    return; // Exit the program
                }
                default -> System.out.println("\nInvalid choice. Please try again.");
            }
        }
    }

    // Display the menu options in a clean, clear format
    private static void showMenu() {
        System.out.println("\n=============================");
        System.out.println("       BookStore Menu        ");
        System.out.println("=============================");
        System.out.println("1. Add a Book");
        System.out.println("2. Remove a Book");
        System.out.println("3. View Books");
        System.out.println("4. Add a User");
        System.out.println("5. Remove a User");
        System.out.println("6. View Users");
        System.out.println("7. Exit");
        System.out.print("\nPlease select an option: ");
    }

    // Get the user's choice with input validation
    private static int getUserChoice() {
        while (!scanner.hasNextInt()) {
            scanner.next(); // clear invalid input
            System.out.print("Invalid input. Please enter a valid number: ");
        }
        return scanner.nextInt();
    }

    // Helper method to read a line of text
    private static String getStringInput(String prompt) {
        System.out.print(prompt);
        scanner.nextLine(); // Clear the buffer
        return scanner.nextLine();
    }

    // Add a new book to the store
    private static void addBookToStore() {
        String title = getStringInput("Enter the book title: ");
        String author = getStringInput("Enter the author: ");
        int year = getIntInput("Enter the year of publication: ");
        String isbn = getStringInput("Enter the ISBN: ");
        int quantity = getIntInput("Enter the quantity: ");

        Book book = new Book(title, author, year, isbn, quantity);
        store.addBook(book);
        System.out.println("\nBook added successfully!");
    }

    // Remove a book from the store
    private static void removeBookFromStore() {
        String isbn = getStringInput("Enter the ISBN of the book to remove: ");
        Book[] books = store.getBooks();
        for (Book book : books) {
            if (book != null && book.getIsbn().equals(isbn)) {
                store.removeBook(book);
                System.out.println("\nBook removed successfully.");
                return;
            }
        }
        System.out.println("\nBook not found with that ISBN.");
    }

    // View all books in the store
    private static void viewBooksInStore() {
        Book[] books = store.getBooks();
        if (books.length == 0) {
            System.out.println("\nNo books available in the store.");
        } else {
            System.out.println("\nAvailable Books:");
            for (Book book : books) {
                if (book != null) {
                    System.out.println(book.bookInfo());
                }
            }
        }
    }

    // Add a new user to the system
    private static void addUserToStore() {
        String name = getStringInput("Enter the user's name: ");
        String id = getStringInput("Enter the user ID: ");
        User user = new User(name, id);
        store.addUser(user);
        System.out.println("\nUser added successfully!");
    }

    // Remove a user from the system
    private static void removeUserFromStore() {
        String id = getStringInput("Enter the User ID to remove: ");
        User[] users = store.getUsers();
        for (User user : users) {
            if (user != null && user.getId().equals(id)) {
                store.removeUser(user);
                System.out.println("\nUser removed successfully.");
                return;
            }
        }
        System.out.println("\nUser not found with that ID.");
    }

    // View all users in the system
    private static void viewUsers() {
        User[] users = store.getUsers();
        if (users.length == 0) {
            System.out.println("\nNo users in the system.");
        } else {
            System.out.println("\nRegistered Users:");
            for (User user : users) {
                if (user != null) {
                    System.out.println(user.userInfo());
                }
            }
        }
    }

    // Helper method to get integer input with validation
    private static int getIntInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            scanner.next(); // clear invalid input
            System.out.print("Invalid input. Please enter a valid number: ");
        }
        return scanner.nextInt();
    }
}
