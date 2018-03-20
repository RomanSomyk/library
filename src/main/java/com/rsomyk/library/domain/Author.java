package com.rsomyk.library.domain;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "author_id")
    private Long id;

    @Column(name = "author_name")
    private String fullName;

    @ManyToMany(mappedBy = "bookAuthor")
    private Set<Book> books;

    public Author() {
    }

    public Author(String fullName) {
        this.fullName = fullName;
    }

    public Long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
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
}
