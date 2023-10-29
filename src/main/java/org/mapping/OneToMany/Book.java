package org.mapping.OneToMany;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "books")
public class Book {
    @Id
    private int bookId;
    private String bookTitle;

    @ManyToOne
    private Author author;

    // default constructor
    public Book() {
    }

    // parameterized constructor
    public Book(int bookId, String bookTitle, Author author) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.author = author;
    }

    // getters and setters

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
