package com.rsomyk.library.repository;

import com.rsomyk.library.domain.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BooksRepository extends JpaRepository<Books, Long> {

    Books findBooksByBookAuthor(String bookAuthor);

    List<Books> findBooksByBookAuthor(Long id);

}
