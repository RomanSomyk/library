package com.rsomyk.library.repository;

import com.rsomyk.library.domain.Authors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorsRepository extends JpaRepository<Authors, Long> {
    Authors findAuthorsByBooks(String bookName);


}
