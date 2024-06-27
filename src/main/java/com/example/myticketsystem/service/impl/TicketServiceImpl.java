package com.example.myticketsystem.service.impl;

import com.example.myticketsystem.entity.Ticket;
import com.example.myticketsystem.repository.TicketRepository;
import com.example.myticketsystem.service.TicketService;
import com.example.myticketsystem.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private EmailService emailService;

    @Override
    public Ticket save(Ticket ticket) {
        Ticket savedTicket = ticketRepository.save(ticket);
        emailService.sendEmail("ballacoulibaly187@gmail.com", ticket.getUser().getEmail(),"Ticket Created", "Your ticket has been created.");
        return savedTicket;
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
        return ticketRepository.save(ticket);
    }

    @Override
    public void deleteById(Long id) {
        ticketRepository.deleteById(id);
    }

    @Override
    public void updateTicketResolvedAt(Long ticketId) {
        Optional<Ticket> optionalTicket = ticketRepository.findById(ticketId);
        if (optionalTicket.isPresent()) {
            Ticket ticket = optionalTicket.get();
            ticket.resolveTicket(); // Met à jour la date de résolution dans l'entité Ticket
            ticketRepository.save(ticket); // Enregistre la mise à jour du ticket
        } else {
            throw new IllegalArgumentException("Ticket not found with id: " + ticketId);
        }
    }
}
