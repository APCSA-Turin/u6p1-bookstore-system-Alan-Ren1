package com.example.project;

public class Book {

    private String title;
    private String author;
    private int yearPublished;
    private String isbn;
    private int quantity;

    // Constructor
    public Book(String title, String author, int yearPublished, String isbn, int quantity) {
        this.title = title != null ? title : "Unknown Title";
        this.author = author != null ? author : "Unknown Author";
        this.yearPublished = yearPublished;
        this.isbn = isbn != null ? isbn : "Unknown ISBN";
        this.quantity = Math.max(quantity, 0); 
    }

    // Getters and Setters
    // Getter method of the title of the book
    public String getTitle() {
        return title;
    }

    // Set title of the book
    public void setTitle(String title) {
        this.title = title != null ? title : "Unknown Title";
    }
    
    // Getter method to get the author of the book
    public String getAuthor() {
        return author;
    }

       // Setter method to set the book's author
    public void setAuthor(String author) {
        this.author = author != null ? author : "Unknown Author";
    }
    //Getter method to retrieve the year the book was published
    public int getYearPublished() {
        return yearPublished;
    }

    // Setter method to set the book's publication year
    // Ensures that the year is positive
    public void setYearPublished(int yearPublished) {
        if (yearPublished > 0) {
            this.yearPublished = yearPublished;
        } else {
            System.out.println("Invalid year published. Must be positive.");
        }
    }

     // Getter method to retrieve the book's ISBN
    public String getIsbn() {
        return isbn;
    }

        // Setter method to set the book's ISBN
    // If ISBN is null, assigns a default value
    public void setIsbn(String isbn) {
        this.isbn = isbn != null ? isbn : "Unknown ISBN";
    }

        // Getter method to retrieve the quantity of the book
    public int getQuantity() {
        return quantity;
    }

      // Setter method to set the book's quantity
    // Ensures that quantity is non-negative
    public void setQuantity(int quantity) {
        if (quantity >= 0) {
            this.quantity = quantity;
        } else {
            System.out.println("Quantity cannot be negative. Setting to 0.");
            this.quantity = 0;  // If quantity is negative, sets it to 0
        }
    }

        // Method to decrement the quantity of the book
    // Ensures that quantity does not go below 0
    public void decrementQuantity() {
        if (quantity > 0) {
            quantity--; // Decrease the quantity by 1
        } else {
            System.out.println("Cannot decrement quantity. Book is out of stock."); //error message
        }
    }

    // Method to return the details of the book as a formatted string
    // Includes title, author, year, ISBN, and quantity
    public String bookInfo() {
        return "Title: " + title + ", Author: " + author + ", Year: " + yearPublished +
               ", ISBN: " + isbn + ", Quantity: " + quantity;
    }
}
