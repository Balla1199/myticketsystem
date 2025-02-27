package com.example.myticketsystem.controller;

import com.example.myticketsystem.entity.Ticket;
import com.example.myticketsystem.entity.User;
import com.example.myticketsystem.service.EmailService;
import com.example.myticketsystem.service.TicketService;
import com.example.myticketsystem.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
@Tag(name = "ticket controller",description = "controlleur de ticket")

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @Autowired
    private UserService userService;

    @Autowired
    private EmailService emailService;
    @Operation(summary = "creer ticket",description = "la creation de ticket")
    @PostMapping("/create")
    public ResponseEntity<Ticket> createTicket(@RequestBody Ticket ticket, @AuthenticationPrincipal UserDetails userDetails) {
        User user = userService.findByEmail(userDetails.getUsername());
        ticket.setUser(user);
        ticket.setCreatedAt(new Date()); // Set creation date

        Ticket savedTicket = ticketService.save(ticket);


        return ResponseEntity.ok(savedTicket);
    }

    @Operation(summary = "lister ticket",description = "afficher la liste des tickets")
    @GetMapping("/read")
    public ResponseEntity<List<Ticket>> getAllTickets() {
        return ResponseEntity.ok(ticketService.findAll());
    }

    @Operation(summary = "rechercher ticket",description = "rechercher ticket par id")
    @GetMapping("/{id}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable Long id) {
        return ticketService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @Operation(summary = "modifier ticket",description = "la modification de ticket")
    @PutMapping("/update/{id}")
    public ResponseEntity<Ticket> updateTicket(@PathVariable Long id, @RequestBody Ticket ticket) {
        ticket.setId(id);
        return ResponseEntity.ok(ticketService.update(ticket));
    }

    @Operation(summary = "supprimer ticket",description = "la suppression de ticket")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTicket(@PathVariable Long id) {
        ticketService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
