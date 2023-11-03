package com.example.cs4blogmanagement.repository;

import com.example.cs4blogmanagement.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBlogRepository extends JpaRepository<Blog, Long> {
    Iterable<Blog> findAllByTitleContaining(String title);
}
