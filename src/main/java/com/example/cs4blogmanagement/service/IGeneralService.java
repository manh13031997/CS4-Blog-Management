package com.example.cs4blogmanagement.service;

import com.example.cs4blogmanagement.model.Blog;

import java.util.List;
import java.util.Optional;

public interface IGeneralService<T> {
    Iterable<T> findAll();
    Optional<T> findById(Long id);
    Iterable<T> findAllByName(String name);
    void remove(Long id);
    void save(T t);
    void restore(Long id);
<<<<<<< HEAD
}
=======
}
>>>>>>> 91937f5af1b68a94f45f673ef205378ebd88c8f5
