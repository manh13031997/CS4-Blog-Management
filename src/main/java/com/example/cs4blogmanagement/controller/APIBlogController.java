package com.example.cs4blogmanagement.controller;


import com.example.cs4blogmanagement.model.Blog;
import com.example.cs4blogmanagement.model.User;
import com.example.cs4blogmanagement.service.blog.IBlogService;
import com.example.cs4blogmanagement.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/blog")
public class APIBlogController {
    @Autowired
    IBlogService blogService;

    @Autowired
    IUserService userService;
    @GetMapping("")
    public ResponseEntity<Iterable<Blog>> showAllBlog() {
        List<Blog> blogList = (List<Blog>) blogService.findAll();
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    @GetMapping("/categoryIllegal")
    public ResponseEntity<Iterable<Blog>> showAllCategoryIllegal() {
        List<Blog> categoryList = (List<Blog>) blogService.findAll();
        if (categoryList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }
    @PostMapping
    public  ResponseEntity<?> createBlog(@RequestBody Blog blog) {
        blogService.save(blog);
       return ResponseEntity.ok("tạo mới thành công");
    }
    @GetMapping("/getAllBlogByUser/{id}")
    public List<Blog> getAllBlogByUser(@PathVariable Long id) {
        Optional<User> user = userService.findById(id);
        List<Blog> postsOptional = blogService.findAllByIdUser(user.get());
        return (postsOptional);
    }
    @GetMapping("/getAllBlogUser/{id}")
    public List<Blog> getAllBlogUser(@PathVariable Long id) {
        Optional<User> user = userService.findById(id);
        List<Blog> postsOptional = blogService.findAllByIdUser(user.get());
        return (postsOptional);
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
    public ResponseEntity<Blog> updateBlog(@PathVariable Long id, @RequestBody Blog blog) {
        Optional<Blog> blogOptional = blogService.findById(id);
        if (!blogOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        blog.setId(id);
        blog.setTime(LocalDateTime.now());  // Lay ve thoi gian hien tai cua he thong, KDL khai bao bien bat buoc phai la LocalDateTime
        blogService.save(blog);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePosts(@PathVariable Long id) {
        Optional<Blog> blogOptional = blogService.findById(id);
        if (!blogOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        blogService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
