package com.rsomyk.library.repository;

import com.rsomyk.library.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BooksRepository extends JpaRepository<Book, Long> {

    Book findBooksByBookAuthor(String bookAuthor);

    List<Book> findBooksByBookAuthorId(Long id);

}
