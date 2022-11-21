package pl.edu.pjwstk.booksmpr35.model;

import pl.edu.pjwstk.booksmpr35.model.enums.BookType;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @OneToOne
    @JoinColumn(name ="author_id")
    private Author author;
    @Enumerated(EnumType.STRING)
    private BookType bookType;
    private LocalDate publishedDate;
    private String publisher;

    public Book() {
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setBookType(BookType bookType) {
        this.bookType = bookType;
    }

    public void setPublishedDate(LocalDate publishedDate) {
        this.publishedDate = publishedDate;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Book(String title, Author author, BookType bookType, LocalDate publishedDate, String publisher) {
        this.title = title;
        this.author = author;
        this.bookType = bookType;
        this.publishedDate = publishedDate;
        this.publisher = publisher;
    }
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public BookType getBookType() {
        return bookType;
    }

    public LocalDate getPublishedDate() {
        return publishedDate;
    }

    public String getPublisher() {
        return publisher;
    }
}
