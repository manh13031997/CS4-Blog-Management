package com.example.cs4blogmanagement.controller;


import com.example.cs4blogmanagement.model.Blog;
import com.example.cs4blogmanagement.service.posts.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/blog")
public class APIBlogController {
    @Autowired
    IBlogService blogService;

    @GetMapping("")
    public ResponseEntity<Iterable<Blog>> showAllBlog() {
        List<Blog> blogList = (List<Blog>) blogService.findAll();
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Blog> findPostsById(@PathVariable Long id) {
        Optional<Blog> postsOptional = blogService.findById(id);
        if (!postsOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(postsOptional.get(), HttpStatus.OK);
    }
    @GetMapping("/find")
    public ResponseEntity<Iterable<Blog>> findAllPostsByName(@RequestParam String name) {
        List<Blog> postsList = (List<Blog>) blogService.findAllByName(name);
        if (postsList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(postsList, HttpStatus.OK);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Blog> updatePosts(@PathVariable Long id, @RequestBody Blog blog) {
        Optional<Blog> postsOptional = blogService.findById(id);
        if (!postsOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        blog.setId(id);
        blogService.save(blog);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Blog> deletePosts(@PathVariable Long id) {
        Optional<Blog> postsOptional = blogService.findById(id);
        if (!postsOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        blogService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
