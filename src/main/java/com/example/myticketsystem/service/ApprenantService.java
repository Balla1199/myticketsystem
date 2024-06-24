package com.example.myticketsystem.service;

import com.example.myticketsystem.entity.Apprenant;

import java.util.List;
import java.util.Optional;

public interface ApprenantService {
    Apprenant save(Apprenant apprenant);
    List<Apprenant> findAll();
    Optional<Apprenant> findById(Long id);
    void deleteById(Long id);
}
