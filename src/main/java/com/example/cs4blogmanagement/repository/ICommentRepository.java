package com.example.cs4blogmanagement.repository;

import com.example.cs4blogmanagement.model.Comment;
import com.example.cs4blogmanagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICommentRepository extends JpaRepository<Comment, Long> {
    Iterable<Comment> findAllByContentContaining(String content);
<<<<<<< HEAD
}
=======
}
>>>>>>> 91937f5af1b68a94f45f673ef205378ebd88c8f5
