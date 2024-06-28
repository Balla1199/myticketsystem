package com.example.myticketsystem.controller;

import com.example.myticketsystem.entity.Formateur;
import com.example.myticketsystem.service.FormateurService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(name = "formateur controller",description = "controlleur de formateur")
@RestController
@RequestMapping("/api/formateurs")
public class FormateurController {

    @Autowired
    private FormateurService formateurService;
    @Operation(summary = "creer formateur",description = "la creation de formateur")
    @PostMapping("/create")
    public ResponseEntity<Formateur> createFormateur(@RequestBody Formateur formateur) {
        return ResponseEntity.ok(formateurService.save(formateur));
    }

    @Operation(summary = "lister les formateurs",description = "afficher la liste des formateurs")
    @GetMapping("/read")
    public ResponseEntity<List<Formateur>> getAllFormateurs() {
        return ResponseEntity.ok(formateurService.findAll());
    }

    @Operation(summary = "rechercher formateur",description = "rechercher formateur par id")
    @GetMapping("/{id}")
    public ResponseEntity<Formateur> getFormateurById(@PathVariable Long id) {
        return formateurService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "modifier formateur",description = "la modification de formateur")
    @PutMapping("/update/{id}")
    public ResponseEntity<Formateur> updateFormateur(@PathVariable Long id, @RequestBody Formateur formateur) {
        formateur.setId(id);
        return ResponseEntity.ok(formateurService.save(formateur));
    }

    @Operation(summary = "supprimer formateur",description = "la suppresion de formateur")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteFormateur(@PathVariable Long id) {
        formateurService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
