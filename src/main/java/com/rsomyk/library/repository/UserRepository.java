package com.rsomyk.library.repository;

import com.rsomyk.library.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * Query which search user with the given username.
     *
     * @param userName must not be {@literal null}.
     * @return
     */
    User findByUsername(String userName);
}
