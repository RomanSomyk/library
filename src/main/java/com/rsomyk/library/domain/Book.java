package com.rsomyk.library.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "book_id")
    private Long id;

    @Column(name = "book_name")
    @NotNull
    private String bookName;

    @Column(name = "genre")
    @NotNull
    private String genre;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "book_author", joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id", referencedColumnName = "author_id"))
    private List<Author> bookAuthor = new ArrayList<>();

    public Book() {
    }

    public Book(String bookName, String genre, List<Author> bookAuthor) {
        this.bookName = bookName;
        this.genre = genre;
        this.bookAuthor = bookAuthor;
    }

    public Long getId() {
        return id;
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

    public List<Author> getBooksAutors() {
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
}