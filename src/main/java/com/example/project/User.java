package com.example.project;

public class User {
  
    private String name;
    private String Id;
    private Book[] books;


    public User(String name, String Id) {
        this.name = name;
        this.Id = Id;
        this.books = new Book[5];
        for (int i = 0; i < books.length; i++) {
            books[i] = null; 
        }
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

 
    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }


    public Book[] getBooks() {
        return books;
    }

    public void setBooks(Book[] books) {
        if (books != null && books.length == 5) {
            this.books = books;
        } else {
            System.out.println("Books array must have exactly 5 elements.");
        }
    }

    public String bookListInfo() {
        StringBuilder bookList = new StringBuilder();
        for (Book book : books) {
            if (book == null) {
                bookList.append("empty\n");
            } else {
                bookList.append(book.bookInfo()).append("\n");
            }
        }
        return bookList.toString();
    }

    public String userInfo() {
        return "Name: " + name + "\nId: " + Id + "\nBooks: \n" + bookListInfo();
    }
}