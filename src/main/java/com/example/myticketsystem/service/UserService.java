package com.example.myticketsystem.service;

import com.example.myticketsystem.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User findByUsername(String username);
    User save(User user);
    List<User> findAll();
    Optional<User> findById(Long id);
    void deleteById(Long id);
}
