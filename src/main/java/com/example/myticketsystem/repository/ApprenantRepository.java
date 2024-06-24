package com.example.myticketsystem.repository;

import com.example.myticketsystem.entity.Apprenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApprenantRepository extends JpaRepository<Apprenant, Long> {
}
