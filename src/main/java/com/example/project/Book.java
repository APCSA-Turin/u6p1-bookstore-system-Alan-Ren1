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
    //get title
    public String getTitle() {
        return title;
    }

    //set title
    public void setTitle(String title) {
        this.title = title != null ? title : "Unknown Title";
    }
    
    //get author
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author != null ? author : "Unknown Author";
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int yearPublished) {
        if (yearPublished > 0) {
            this.yearPublished = yearPublished;
        } else {
            System.out.println("Invalid year published. Must be positive.");
        }
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn != null ? isbn : "Unknown ISBN";
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity >= 0) {
            this.quantity = quantity;
        } else {
            System.out.println("Quantity cannot be negative. Setting to 0.");
            this.quantity = 0;
        }
    }

    public void decrementQuantity() {
        if (quantity > 0) {
            quantity--;
        } else {
            System.out.println("Cannot decrement quantity. Book is out of stock.");
        }
    }

    public String bookInfo() {
        return "Title: " + title + ", Author: " + author + ", Year: " + yearPublished +
               ", ISBN: " + isbn + ", Quantity: " + quantity;
    }
}
