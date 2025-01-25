public class Book {

    private String title;  // Title of the book
    private String author; // Author of the book
    private int yearPublished; // The year the book was published
    private String isbn; // ISBN number of the book
    private int quantity; // Quantity of books available

    // Constructor that initializes all fields of the book
    // It also ensures that the input values are valid or sets default values
    public Book(String title, String author, int yearPublished, String isbn, int quantity) {
        this.title = title != null ? title : "Unknown Title"; // If title is null, use a default value
        this.author = author != null ? author : "Unknown Author"; // If author is null, use a default value
        this.yearPublished = yearPublished; // Direct assignment, no validation here
        this.isbn = isbn != null ? isbn : "Unknown ISBN"; // If isbn is null, use a default value
        this.quantity = Math.max(quantity, 0); // Ensures quantity is non-negative; if it's less than 0, it becomes 0
    }

    // Getter method to retrieve the book's title
    public String getTitle() {
        return title;
    }

    // Setter method to set the book's title
    // If title is null, assigns a default value
    public void setTitle(String title) {
        this.title = title != null ? title : "Unknown Title"; 
    }

    // Getter method to retrieve the book's author
    public String getAuthor() {
        return author;
    }

    // Setter method to set the book's author
    // If author is null, assigns a default value
    public void setAuthor(String author) {
        this.author = author != null ? author : "Unknown Author"; 
    }

    // Getter method to retrieve the year the book was published
    public int getYearPublished() {
        return yearPublished;
    }

    // Setter method to set the book's publication year
    // Ensures that the year is positive
    public void setYearPublished(int yearPublished) {
        if (yearPublished > 0) {  // Ensures the year is valid (positive)
            this.yearPublished = yearPublished;
        } else {
            System.out.println("Invalid year published. Must be positive."); // Error message for invalid year
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
        if (quantity >= 0) {  // Ensures the quantity is not negative
            this.quantity = quantity;
        } else {
            System.out.println("Quantity cannot be negative. Setting to 0."); // Error message for invalid quantity
            this.quantity = 0; // If quantity is negative, sets it to 0
        }
    }

    // Method to decrement the quantity of the book
    // Makes sure that the quantity does not go below 0
    public void decrementQuantity() {
        if (quantity > 0) {  // Only decrements if quantity is greater than 0
            quantity--;  // Decrease the quantity by 1
        } else {
            System.out.println("Cannot decrement quantity. Book is out of stock."); // Error message if stock is 0
        }
    }

    // Method to return the details of the book as a formatted string
    // Includes title, author, year, ISBN, and quantity
    public String bookInfo() {
        return "Title: " + title + ", Author: " + author + ", Year: " + yearPublished +
               ", ISBN: " + isbn + ", Quantity: " + quantity;
    }
}
