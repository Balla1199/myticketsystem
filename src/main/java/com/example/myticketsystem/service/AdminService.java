package com.example.myticketsystem.service;

import com.example.myticketsystem.entity.Admin;

import java.util.List;
import java.util.Optional;

public interface AdminService {
    Admin save(Admin admin);
    List<Admin> findAll();
    Optional<Admin> findById(Long id);
    Admin update(Admin admin);
    void deleteById(Long id);
}
