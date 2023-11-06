package com.example.cs4blogmanagement.service.comment;

import com.example.cs4blogmanagement.model.Comment;
import com.example.cs4blogmanagement.repository.ICommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CommentService implements ICommentService{
    @Autowired
    ICommentRepository commentRepository;
    @Override
    public Iterable<Comment> findAll() {
        return commentRepository.findAll();
    }


    @Override
    public Optional<Comment> findById(Long id) {
        return commentRepository.findById(id);
    }

    @Override
    public Iterable<Comment> findAllByName(String content) {
        return commentRepository.findAllByContentContaining(content);
    }

    @Override
    public void remove(Long id) {

    }


    @Override
    public void save(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public void restore(Long id) {

    }
}
