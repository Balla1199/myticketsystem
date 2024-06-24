package com.example.myticketsystem.service;

import com.example.myticketsystem.entity.Formateur;

import java.util.List;
import java.util.Optional;

public interface FormateurService {
    Formateur save(Formateur formateur);
    List<Formateur> findAll();
    Optional<Formateur> findById(Long id);
    void deleteById(Long id);
}
