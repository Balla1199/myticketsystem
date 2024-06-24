package com.example.myticketsystem.repository;

import com.example.myticketsystem.entity.BaseConnaissance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseConnaissanceRepository extends JpaRepository<BaseConnaissance, Integer> {
    // Définir des méthodes supplémentaires si nécessaire
}
