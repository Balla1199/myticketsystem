package com.example.myticketsystem.service.impl;

import com.example.myticketsystem.entity.Formateur;
import com.example.myticketsystem.repository.FormateurRepository;
import com.example.myticketsystem.service.FormateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FormateurServiceImpl implements FormateurService {

    @Autowired
    private FormateurRepository formateurRepository;

    @Override
    public Formateur save(Formateur formateur) {
        return formateurRepository.save(formateur);
    }

    @Override
    public List<Formateur> findAll() {
        return formateurRepository.findAll();
    }

    @Override
    public Optional<Formateur> findById(Long id) {
        return formateurRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        formateurRepository.deleteById(id);
    }
}
