package com.rsomyk.library.repository;

import com.rsomyk.library.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorsRepository extends JpaRepository<Author, Long> {
    @Query(nativeQuery = true, value = "select count(ba.book_id) " +
            "from book_author ba " +
            "where ba.author_id = :author_id")
    Integer countBooksOfAuthor(@Param("author_id") Long authorId);

}
