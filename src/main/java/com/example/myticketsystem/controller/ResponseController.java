package com.example.myticketsystem.controller;

import com.example.myticketsystem.entity.Response;
import com.example.myticketsystem.service.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/responses")
public class ResponseController {
    @Autowired
    private ResponseService responseService;

    @PostMapping("/create/{ticketId}")
    public ResponseEntity<Response> createResponseForTicket(@PathVariable Long ticketId, @RequestBody Response response) {
        response.setTicketId(ticketId);
        // Set current date for response
        response.setDate(new Date());
        return ResponseEntity.ok(responseService.save(response));
    }

    @GetMapping("/read/{ticketId}")
    public ResponseEntity<List<Response>> getAllResponsesForTicket(@PathVariable Long ticketId) {
        return ResponseEntity.ok(responseService.findAllByTicketId(ticketId));
    }

    @PutMapping("/update/{responseId}")
    public ResponseEntity<Response> updateResponse(@PathVariable Long responseId, @RequestBody Response updatedResponse) {
        updatedResponse.setId(responseId);
        return ResponseEntity.ok(responseService.save(updatedResponse));
    }

    @DeleteMapping("/delete/{responseId}")
    public ResponseEntity<Void> deleteResponse(@PathVariable Long responseId) {
        responseService.deleteById(responseId);
        return ResponseEntity.noContent().build();
    }
}
