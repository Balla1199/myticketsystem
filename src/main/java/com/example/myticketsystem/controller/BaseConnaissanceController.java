package com.example.myticketsystem.controller;

import com.example.myticketsystem.entity.BaseConnaissance;
import com.example.myticketsystem.service.BaseConnaissanceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(name = "base controller",description = "controlleur de base")
@RestController
@RequestMapping("/api/baseconnaissance")
public class BaseConnaissanceController {

    @Autowired
    private BaseConnaissanceService baseConnaissanceService;
    @Operation(summary = "creer base",description = "la creation de  labase")
    @PostMapping("/create")
    public ResponseEntity<BaseConnaissance> createBaseConnaissance(@RequestBody BaseConnaissance baseConnaissance) {
        BaseConnaissance createdBaseConnaissance = baseConnaissanceService.save(baseConnaissance);
        return ResponseEntity.ok(createdBaseConnaissance);
    }

    @Operation(summary = "afficher base",description = "affichage de la base")
    @GetMapping("/all")
    public ResponseEntity<List<BaseConnaissance>> getAllBaseConnaissances() {
        List<BaseConnaissance> baseConnaissances = baseConnaissanceService.findAll();
        return ResponseEntity.ok(baseConnaissances);
    }

    @Operation(summary = "rechercher base",description = "rechercher base par id")
    @GetMapping("/{id}")
    public ResponseEntity<BaseConnaissance> getBaseConnaissanceById(@PathVariable int id) {
        BaseConnaissance baseConnaissance = baseConnaissanceService.findById(id);
        if (baseConnaissance != null) {
            return ResponseEntity.ok(baseConnaissance);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "modifier base",description = "la modification de la base")
    @PutMapping("/update/{id}")
    public ResponseEntity<BaseConnaissance> updateBaseConnaissance(@RequestBody BaseConnaissance baseConnaissance) {
        BaseConnaissance updatedBaseConnaissance = baseConnaissanceService.update(baseConnaissance);
        return ResponseEntity.ok(updatedBaseConnaissance);
    }

    @Operation(summary = "supprimer base",description = "la suppression de la base")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteBaseConnaissance(@PathVariable int id) {
        baseConnaissanceService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
