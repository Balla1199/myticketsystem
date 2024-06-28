package com.example.myticketsystem.controller;

import com.example.myticketsystem.entity.Apprenant;
import com.example.myticketsystem.service.ApprenantService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(name = "ticket apprenant",description = "controlleur d'apprenant")
@RestController
@RequestMapping("/api/apprenants")
public class ApprenantController {

    @Autowired
    private ApprenantService apprenantService;
    @Operation(summary = "creer apprenant",description = "la creation de l'apprenant")
    @PostMapping("/create")
    public ResponseEntity<Apprenant> createApprenant(@RequestBody Apprenant apprenant) {
        return ResponseEntity.ok(apprenantService.save(apprenant));
    }
    @Operation(summary = "lister apprenant",description = "afficher la lite des apprenants")
    @GetMapping("/read")
    public ResponseEntity<List<Apprenant>> getAllApprenants() {
        return ResponseEntity.ok(apprenantService.findAll());
    }
    @Operation(summary = "rechercher apprenant",description = "rechercher apprenant par id")
    @GetMapping("/{id}")
    public ResponseEntity<Apprenant> getApprenantById(@PathVariable Long id) {
        return apprenantService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @Operation(summary = "modifier apprenant",description = "la modification de l'apprenant")
    @PutMapping("/update/{id}")
    public ResponseEntity<Apprenant> updateApprenant(@PathVariable Long id, @RequestBody Apprenant apprenant) {
        apprenant.setId(id);
        return ResponseEntity.ok(apprenantService.save(apprenant));
    }
    @Operation(summary = "suppriner apprenant",description = "la suppression de l'apprenant")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteApprenant(@PathVariable Long id) {
        apprenantService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
