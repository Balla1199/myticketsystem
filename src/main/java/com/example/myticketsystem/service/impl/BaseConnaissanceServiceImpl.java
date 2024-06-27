package com.example.myticketsystem.service.impl;

import com.example.myticketsystem.entity.BaseConnaissance;
import com.example.myticketsystem.repository.BaseConnaissanceRepository;
import com.example.myticketsystem.service.BaseConnaissanceService;
import com.example.myticketsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaseConnaissanceServiceImpl implements BaseConnaissanceService {

    @Autowired
    private BaseConnaissanceRepository baseConnaissanceRepository;

    @Autowired
    private UserService userService;

    @Override
    public BaseConnaissance save(BaseConnaissance baseConnaissance) {
        // Récupérer l'utilisateur actuellement authentifié
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String email;
        if (principal instanceof UserDetails) {
            email = ((UserDetails) principal).getUsername();
        } else {
            email = principal.toString();
        }

        // Récupérer l'utilisateur à partir de son email
        Long userId = userService.findByEmail(email).getId();

        // Définir l'ID de l'utilisateur
        baseConnaissance.setUserId(userId);

        // Enregistrer l'entrée
        return baseConnaissanceRepository.save(baseConnaissance);
    }

    @Override
    public List<BaseConnaissance> findAll() {
        return baseConnaissanceRepository.findAll();
    }

    @Override
    public BaseConnaissance findById(int id) {
        return baseConnaissanceRepository.findById(id).orElse(null);
    }

    @Override
    public BaseConnaissance update(BaseConnaissance baseConnaissance) {
        return baseConnaissanceRepository.save(baseConnaissance);
    }

    @Override
    public void deleteById(int id) {
        baseConnaissanceRepository.deleteById(id);
    }
}
