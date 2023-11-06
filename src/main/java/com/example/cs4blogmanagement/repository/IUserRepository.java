package com.example.cs4blogmanagement.repository;

<<<<<<< HEAD
=======

>>>>>>> 91937f5af1b68a94f45f673ef205378ebd88c8f5
import com.example.cs4blogmanagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    Iterable<User> findAllByUsernameContaining(String name);
    User findByUsernameAndPassword(String username, String password);
<<<<<<< HEAD
}
=======
}
>>>>>>> 91937f5af1b68a94f45f673ef205378ebd88c8f5
