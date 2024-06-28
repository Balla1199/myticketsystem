package com.example.myticketsystem.controller;

import com.example.myticketsystem.entity.Response;
import com.example.myticketsystem.service.ResponseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(name = "reponse controller",description = "controlleur de reponse")
@RestController
@RequestMapping("/api/responses")
public class ResponseController {

    @Autowired
    private ResponseService responseService;
    @Operation(summary = "creer reponse",description = "la creation de reponse")
    @PostMapping("/create")
    public ResponseEntity<Response> createResponse(@RequestBody Response response) {
        Response savedResponse = responseService.save(response);
        return ResponseEntity.ok(savedResponse);
    }

    @Operation(summary = "rechercher reponse",description = "rechercher reponse par ticket id")
    @GetMapping("/ticket/{ticketId}")
    public ResponseEntity<List<Response>> getResponsesByTicketId(@PathVariable Long ticketId) {
        List<Response> responses = responseService.findAllByTicketId(ticketId);
        return ResponseEntity.ok(responses);
    }

    @Operation(summary = "rechercher reponse",description = "rechercher reponse par id")
    @GetMapping("/read/{id}")
    public ResponseEntity<Response> getResponseById(@PathVariable Long id) {
        Response response = responseService.findById(id);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "modifier reponse",description = "modifier reponse")
    @PutMapping("/update/{id}")
    public ResponseEntity<Response> updateResponse(@PathVariable Long id, @RequestBody Response response) {
        response.setId(id);
        Response updatedResponse = responseService.update(response);
        return ResponseEntity.ok(updatedResponse);
    }

    @Operation(summary = "supprimer reponse",description = "la suppression de reponse")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteResponse(@PathVariable Long id) {
        responseService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
