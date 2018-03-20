package com.rsomyk.library.repository;

import com.rsomyk.library.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorsRepository extends JpaRepository<Author, Long> {
    Author findAuthorsByBooks(String bookName);


}
