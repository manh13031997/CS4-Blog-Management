package com.example.cs4blogmanagement.controller;

import com.example.cs4blogmanagement.model.User;
import com.example.cs4blogmanagement.repository.IUserRepository;
import com.example.cs4blogmanagement.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@CrossOrigin("*")
public class APIUserController {
    @Autowired
    private UserService userService;

    @Autowired
    private IUserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody User user){
        userService.save(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
