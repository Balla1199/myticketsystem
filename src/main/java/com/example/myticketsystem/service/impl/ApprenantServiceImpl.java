package com.example.myticketsystem.service.impl;

import com.example.myticketsystem.entity.Apprenant;
import com.example.myticketsystem.repository.ApprenantRepository;
import com.example.myticketsystem.service.ApprenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApprenantServiceImpl implements ApprenantService {

    @Autowired
    private ApprenantRepository apprenantRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Apprenant save(Apprenant apprenant) {
        apprenant.setPassword(passwordEncoder.encode(apprenant.getPassword()));
        return apprenantRepository.save(apprenant);
    }

    @Override
    public List<Apprenant> findAll() {
        return apprenantRepository.findAll();
    }

    @Override
    public Optional<Apprenant> findById(Long id) {
        return apprenantRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        apprenantRepository.deleteById(id);
    }
}
