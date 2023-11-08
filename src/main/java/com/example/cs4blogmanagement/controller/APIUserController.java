package com.example.cs4blogmanagement.controller;

import com.example.cs4blogmanagement.model.User;
import com.example.cs4blogmanagement.repository.IUserRepository;
import com.example.cs4blogmanagement.service.user.UserService;
import com.example.cs4blogmanagement.service.validate.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/users")
@CrossOrigin("*")
public class APIUserController {
    @Autowired
    private UserService userService;

    @Autowired
    private Validate validate;

    @Autowired
    private IUserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody User user){
        if (user.getAge() >= 1){
            if (validate.validatePhoneNumber(user.getPhoneNumber())){
                if (validate.validateEmail(user.getEmail())){
                    userService.save(user);
                }
            }
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user){
        User user1 = userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
        if (user1 != null){
            return new ResponseEntity<>(user1, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.RESET_CONTENT);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> edit(@PathVariable Long id, @RequestBody User user) {
        Optional<User> userOptional = userRepository.findById(id);
        if (!userOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        user.setId(userOptional.get().getId());
        return new ResponseEntity<>(userRepository.save(user), HttpStatus.OK);
    }
}
