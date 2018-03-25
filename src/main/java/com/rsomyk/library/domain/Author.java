package com.rsomyk.library.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Class which will be presented in database as table
 * named "authors".
 */
@Entity
@Table(name = "authors")
public class Author {

    /**
     * The column which contains the identifier
     * of author. Automatically generated value.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "author_id")
    private Long id;

    /**
     * The column which contains the name
     * of author. Must not be null.
     */
    @Column(name = "author_name")
    @NotNull
    private String fullName;

    /**
     * The collection which contains the books of authors.
     * Presented as a separate one table named book_author.
     */
    @JsonIgnore
    @ManyToMany(cascade = CascadeType.MERGE, mappedBy = "bookAuthor")
    private List<Book> books = new ArrayList<>();

    /**
     * No-argument constructor which used for creating the instantiate
     * of the class.
     */
    public Author() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(id, author.id) &&
                Objects.equals(fullName, author.fullName) &&
                Objects.equals(books, author.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName, books);
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", books=" + books +
                '}';
    }
}
