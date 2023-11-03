package com.example.cs4blogmanagement.service.user;

import com.example.cs4blogmanagement.repository.IUserRepository;
import com.example.cs4blogmanagement.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService{
    @Autowired
    IUserRepository userRepository;
    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }


    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Iterable<User> findAllByName(String name) {
        return userRepository.findAllByUsernameContaining(name);
    }

    @Override
    public void remove(Long id) {

    }


    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void restore(Long id) {

    }

}
