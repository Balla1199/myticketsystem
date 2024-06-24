package com.example.myticketsystem.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "tickets")
@Data
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private String category;
    private String status = "OUVERT"; // Statut par défaut est "OUVERT"

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date createdAt = new Date(); // Date de création prend la date du jour

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private Date updatedAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "resolved_at")
    private Date resolvedAt; // Date de résolution, initialisée à null par défaut

    // Méthode pour mettre à jour la date de résolution automatiquement
    public void resolveTicket() {
        this.resolvedAt = new Date();
    }
}
