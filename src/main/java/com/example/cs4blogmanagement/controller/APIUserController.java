package com.example.cs4blogmanagement.controller;

import com.example.cs4blogmanagement.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@CrossOrigin("*")
public class APIUserController {
    @Autowired
    private UserService userService;






}
