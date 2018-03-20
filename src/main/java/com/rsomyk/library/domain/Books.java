package com.rsomyk.library.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "books")
public class Books {
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
    private List<Authors> bookAuthor = new ArrayList<>();

    public Books() {
    }

    public Books(String bookName, String genre, List<Authors> bookAuthor) {
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

    public List<Authors> getBooksAutors() {
        return bookAuthor;
    }

    public void setBooksAutors(List<Authors> booksAuthors) {
        this.bookAuthor = booksAuthors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Books books = (Books) o;
        return Objects.equals(id, books.id) &&
                Objects.equals(bookName, books.bookName) &&
                Objects.equals(genre, books.genre) &&
                Objects.equals(bookAuthor, books.bookAuthor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bookName, genre, bookAuthor);
    }
}
