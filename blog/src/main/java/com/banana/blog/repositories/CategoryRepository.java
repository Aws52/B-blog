package com.banana.blog.repositories;

import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.banana.blog.domain.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, UUID> {
    @Query("SELECT c FROM Category c LEFT JOIN FETCH c.posts") // will have to send 1 query instead of 1 query for each category to get the post count
    List<Category> findAllWithPostCount();

    boolean existsByNameIgnoreCase(String name);
}
