package com.example.myticketsystem.controller;

import com.example.myticketsystem.entity.Formateur;
import com.example.myticketsystem.service.FormateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/formateurs")
public class FormateurController {

    @Autowired
    private FormateurService formateurService;

    @PostMapping("/create")
    public ResponseEntity<Formateur> createFormateur(@RequestBody Formateur formateur) {
        return ResponseEntity.ok(formateurService.save(formateur));
    }

    @GetMapping("/read")
    public ResponseEntity<List<Formateur>> getAllFormateurs() {
        return ResponseEntity.ok(formateurService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Formateur> getFormateurById(@PathVariable Long id) {
        return formateurService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Formateur> updateFormateur(@PathVariable Long id, @RequestBody Formateur formateur) {
        formateur.setId(id);
        return ResponseEntity.ok(formateurService.save(formateur));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteFormateur(@PathVariable Long id) {
        formateurService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
