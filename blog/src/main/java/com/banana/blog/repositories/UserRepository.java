package com.banana.blog.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.banana.blog.domain.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByEmail(String email); // Optional<> : is for handling the case where a user with the given email might not exist. It allows you to avoid null checks and provides methods to handle the presence or absence of a value gracefully. 
}
