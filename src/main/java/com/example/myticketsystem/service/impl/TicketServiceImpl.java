package com.example.myticketsystem.service.impl;

import com.example.myticketsystem.entity.Ticket;
import com.example.myticketsystem.repository.TicketRepository;
import com.example.myticketsystem.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public Ticket save(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    @Override
    public List<Ticket> findAll() {
        return ticketRepository.findAll();
    }

    @Override
    public Optional<Ticket> findById(Long id) {
        return ticketRepository.findById(id);
    }

    @Override
    public Ticket update(Ticket ticket) {
        if (ticket.getId() == null) {
            throw new IllegalArgumentException("Ticket id cannot be null");
        }
        return ticketRepository.save(ticket);
    }

    @Override
    public void deleteById(Long id) {
        ticketRepository.deleteById(id);
    }
}
