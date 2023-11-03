package com.example.cs4blogmanagement.repository;

import com.example.cs4blogmanagement.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface ICommentRepository {
    Iterable<User> findAllByContentContaining(String content);
}
