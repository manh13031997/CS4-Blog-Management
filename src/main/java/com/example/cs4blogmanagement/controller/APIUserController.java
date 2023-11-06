package com.example.cs4blogmanagement.controller;

import com.example.cs4blogmanagement.model.User;
import com.example.cs4blogmanagement.repository.IUserRepository;
import com.example.cs4blogmanagement.service.user.UserService;
<<<<<<< HEAD
=======
import com.example.cs4blogmanagement.service.validate.Validate;
>>>>>>> 91937f5af1b68a94f45f673ef205378ebd88c8f5
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

<<<<<<< HEAD
=======


>>>>>>> 91937f5af1b68a94f45f673ef205378ebd88c8f5
@RestController
@RequestMapping("/users")
@CrossOrigin("*")
public class APIUserController {
    @Autowired
    private UserService userService;

    @Autowired
<<<<<<< HEAD
=======
    private Validate validate;

    @Autowired
>>>>>>> 91937f5af1b68a94f45f673ef205378ebd88c8f5
    private IUserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody User user){
<<<<<<< HEAD
        userService.save(user);
=======
        if (validate.validateEmail(user.getEmail()) && user.getAge() >= 1){
            userService.save(user);
        }
>>>>>>> 91937f5af1b68a94f45f673ef205378ebd88c8f5
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user){
        User user1 = userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
        if (user1 != null){
            return new ResponseEntity<>("Login successful", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Username or password is incorrect", HttpStatus.OK);
        }
    }
<<<<<<< HEAD
}
=======

}
>>>>>>> 91937f5af1b68a94f45f673ef205378ebd88c8f5
