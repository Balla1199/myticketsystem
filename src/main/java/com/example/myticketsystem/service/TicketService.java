package com.example.myticketsystem.service;

import com.example.myticketsystem.entity.Ticket;

import java.util.List;
import java.util.Optional;

public interface TicketService {
    Ticket save(Ticket ticket);
    List<Ticket> findAll();
    Optional<Ticket> findById(Long id);
    Ticket update(Ticket ticket);
    void deleteById(Long id);
}
