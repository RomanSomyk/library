package com.rsomyk.library.controller.dto;

import java.util.List;

/**
 * DTO for saving new book to database.
 */
public class BookDTO {
    private String bookName;
    private String genre;
    private List<Long> bookAuthorsIds;

    public BookDTO() {
    }

    public BookDTO(String bookName, String genre, List<Long> bookAuthorsIds) {
        this.bookName = bookName;
        this.genre = genre;
        this.bookAuthorsIds = bookAuthorsIds;
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

    public List<Long> getBookAuthorsIds() {
        return bookAuthorsIds;
    }

    public void setBookAuthorsIds(List<Long> bookAuthorsIds) {
        this.bookAuthorsIds = bookAuthorsIds;
    }
}
