package com.example.myticketsystem.repository;

import com.example.myticketsystem.entity.Formateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormateurRepository extends JpaRepository<Formateur, Long> {
}
