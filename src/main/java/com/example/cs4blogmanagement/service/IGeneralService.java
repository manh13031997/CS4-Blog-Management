package com.example.cs4blogmanagement.service;

import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
    public interface IGeneralService<T> {
        Iterable<T> findAll();
        Optional<T> findById(Long id);
        Iterable<T> findAllByName(String name);
        void remove(Long id);
        void save(T t);
        void restore(Long id);
    }

