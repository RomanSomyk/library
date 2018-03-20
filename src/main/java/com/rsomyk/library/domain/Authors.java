package com.rsomyk.library.domain;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "authors")
public class Authors {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "author_id")
    private Long id;

    @Column(name = "author_name")
    private String authorName;

    @ManyToMany(mappedBy = "bookAuthor")
    private Set<Books> books;

    public Authors() {
    }

    public Authors(String authorName) {
        this.authorName = authorName;
    }

    public Long getId() {
        return id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Set<Books> getBooks() {
        return books;
    }

    public void setBooks(Set<Books> books) {
        this.books = books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Authors authors = (Authors) o;
        return Objects.equals(id, authors.id) &&
                Objects.equals(authorName, authors.authorName) &&
                Objects.equals(books, authors.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, authorName, books);
    }
}
