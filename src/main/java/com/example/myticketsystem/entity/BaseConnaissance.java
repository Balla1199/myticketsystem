package com.example.myticketsystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "base_connaissance")
@Data
@NoArgsConstructor
public class BaseConnaissance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String titre;
    private String contenu;
    private String categorie;

    // Constructeur avec champs
    public BaseConnaissance(String titre, String contenu, String categorie) {
        this.titre = titre;
        this.contenu = contenu;
        this.categorie = categorie;
    }
}
