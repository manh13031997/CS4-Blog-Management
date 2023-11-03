package com.example.cs4blogmanagement.service;

import java.util.Optional;

public interface IGeneralService<T> {
    Iterable<T> findAll();
    Optional<T> findById(Long id);
    Iterable<T> findAllByName(String name);
    void remove(Long id);
    void save(T t);
    void restore(Long id);
}
