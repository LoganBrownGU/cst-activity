package com.example;

public class Book {
    public String isbn, title, author;

    public String generateCheckDigit(String group, String publisher, String title) {
        return "";
    }

    public Book(String title, String author, String groupNo, String publisherNo, String titleNo) {
        this.title = title;
        this.author = author;
        
        this.isbn = groupNo + publisherNo + titleNo + "-" + generateCheckDigit(groupNo, publisherNo, titleNo);
    }
}
