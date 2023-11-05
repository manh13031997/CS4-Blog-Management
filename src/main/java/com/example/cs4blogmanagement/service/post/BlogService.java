package com.example.cs4blogmanagement.service.post;

import com.example.cs4blogmanagement.model.Blog;
import com.example.cs4blogmanagement.model.User;
import com.example.cs4blogmanagement.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class BlogService implements IBlogService {
    @Autowired
    IBlogRepository blogRepository;

    @Override
    public Iterable<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public List<Blog> findAllByIdUser(User user) {
        return blogRepository.findAllByUser(user);
    }


    @Override
    public Optional<Blog> findById(Long id) {
        return blogRepository.findById(id);
    }

    @Override
    public Iterable<Blog> findAllByName(String name) {
        return blogRepository.findAllByTitleContaining(name);
    }

    @Override
    @Transactional
    public void remove(Long id) {
        blogRepository.deleteById(id);
    }


    @Override
    public void save(Blog posts) {
        blogRepository.save(posts);
    }

    @Override
    public void restore(Long id) {

    }


}