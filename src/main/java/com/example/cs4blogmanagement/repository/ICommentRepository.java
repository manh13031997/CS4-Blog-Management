package com.example.cs4blogmanagement.repository;

import com.example.cs4blogmanagement.model.Comment;
import com.example.cs4blogmanagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICommentRepository extends JpaRepository<Comment, Long> {
    Iterable<Comment> findAllByContentContaining(String content);
}
