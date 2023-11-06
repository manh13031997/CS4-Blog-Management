package com.example.cs4blogmanagement.repository;

import com.example.cs4blogmanagement.model.Blog;
import com.example.cs4blogmanagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBlogRepository extends JpaRepository<Blog, Long> {
    Iterable<Blog> findAllByTitleContaining(String title);

    List<Blog> findAllByUser(User user);
<<<<<<< HEAD
}
=======
}
>>>>>>> 91937f5af1b68a94f45f673ef205378ebd88c8f5
