package com.example.cs4blogmanagement.repository;

import com.example.cs4blogmanagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    Iterable<User> findAllByUsernameContaining(String name);

    User findByUsernameAndPassword(String username, String password);
}
