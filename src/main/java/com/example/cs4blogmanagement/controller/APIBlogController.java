package com.example.cs4blogmanagement.controller;


import com.example.cs4blogmanagement.model.Blog;
import com.example.cs4blogmanagement.service.posts.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/posts")
public class APIBlogController {
    @Autowired
    IBlogService postsService;

    @GetMapping("")
    public ResponseEntity<Iterable<Blog>> showAllPosts() {
        List<Blog> postsList = (List<Blog>) postsService.findAll();
        if (postsList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(postsList, HttpStatus.OK);
    }
}
