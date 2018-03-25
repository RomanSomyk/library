package com.rsomyk.library.domain;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Class which will be presented in database as table
 * named "books".
 */
@Entity
@Table(name = "books")
public class Book {

    /**
     * The column which contains the identifier
     * of author. Automatically generated value.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "book_id")
    private Long id;

    /**
     * The column which contains the name
     * of user. Must not be null.
     */
    @Column(name = "book_name")
    @NotNull
    private String bookName;

    /**
     * The column which contains the genre
     * of book. Must not be null.
     */
    @Column(name = "genre")
    @NotNull
    private String genre;

    /**
     * The collection which contains the authors of book.
     * Presented as a separate one table named book_author.
     */
    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(name = "book_author",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    private List<Author> bookAuthor = new ArrayList<>();

    /**
     * No-argument constructor which used for creating the instantiate
     * of the class.
     */
    public Book() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public List<Author> getBookAuthor() {
        return bookAuthor;
    }

    public void setBooksAutors(List<Author> booksAuthors) {
        this.bookAuthor = booksAuthors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id) &&
                Objects.equals(bookName, book.bookName) &&
                Objects.equals(genre, book.genre) &&
                Objects.equals(bookAuthor, book.bookAuthor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bookName, genre, bookAuthor);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", genre='" + genre + '\'' +
                ", bookAuthor=" + bookAuthor +
                '}';
    }
}
