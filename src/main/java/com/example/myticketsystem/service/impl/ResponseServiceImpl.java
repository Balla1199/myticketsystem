package com.example.myticketsystem.service.impl;

import com.example.myticketsystem.entity.Response;
import com.example.myticketsystem.entity.Ticket;
import com.example.myticketsystem.entity.User;
import com.example.myticketsystem.repository.ResponseRepository;
import com.example.myticketsystem.service.ResponseService;
import com.example.myticketsystem.service.TicketService;
import com.example.myticketsystem.service.UserService;
import com.example.myticketsystem.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ResponseServiceImpl implements ResponseService {

    @Autowired
    private ResponseRepository responseRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private TicketService ticketService;

    @Autowired
    private EmailService emailService;

    @Override
    public Response save(Response response) {
        // Récupérer l'utilisateur actuellement authentifié
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String email;
        if (principal instanceof UserDetails) {
            email = ((UserDetails) principal).getUsername(); // assuming username is the email
        } else {
            email = principal.toString();
        }

        // Récupérer l'utilisateur à partir de l'email
        User user = userService.findByEmail(email);

        // Ajouter l'utilisateur et la date à la réponse
        response.setUser(user);
        response.setDate(new Date());

        // Enregistrer la réponse
        Response savedResponse = responseRepository.save(response);

        // Mettre à jour la date de résolution du ticket associé
        ticketService.updateTicketResolvedAt(response.getTicketId());

        // Envoyer un e-mail au créateur du ticket
        Ticket ticket = ticketService.findById(response.getTicketId()).orElseThrow(() -> new RuntimeException("Ticket not found"));
        emailService.sendEmail("ballacoulibaly187@gmail.com", ticket.getUser().getEmail(), "New Response", "Your ticket has a new response.");

        return savedResponse;
    }

    @Override
    public List<Response> findAllByTicketId(Long ticketId) {
        return responseRepository.findByTicketId(ticketId);
    }

    @Override
    public Response findById(Long id) {
        Optional<Response> optionalResponse = responseRepository.findById(id);
        return optionalResponse.orElse(null);
    }

    @Override
    public Response update(Response response) {
        return responseRepository.save(response);
    }

    @Override
    public void deleteById(Long id) {
        responseRepository.deleteById(id);
    }
}
