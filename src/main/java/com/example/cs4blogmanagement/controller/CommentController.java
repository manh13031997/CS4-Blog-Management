package com.example.cs4blogmanagement.controller;

import com.example.cs4blogmanagement.model.Comment;
import com.example.cs4blogmanagement.service.comment.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    ICommentService commentService;

    @GetMapping("")
    public ResponseEntity<Iterable<Comment>> showAllUser() {
        List<Comment> commentList = (List<Comment>) commentService.findAll();
        if (commentList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(commentList, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Comment> findUserById(@PathVariable Long id) {
        Optional<Comment> commentOptional = commentService.findById(id);
        if (!commentOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(commentOptional.get(), HttpStatus.OK);
    }
    //    @GetMapping("/find")
//    public ResponseEntity<Iterable<Comment>> findAllUserByName(@RequestParam String content) {
//        List<Comment> commentList = (List<Comment>) commentService.findAllByName(content);
//        if (userList.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(userList, HttpStatus.OK);
//    }
    @PutMapping("/{id}")
    public ResponseEntity<Comment> updateUser(@PathVariable Long id, @RequestBody Comment comment) {
        Optional<Comment> commentOptional = commentService.findById(id);
        if (!commentOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        comment.setId(id);
        commentService.save(comment);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Comment> deleteUser(@PathVariable Long id) {
        Optional<Comment> commentOptional = commentService.findById(id);
        if (!commentOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        commentService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}