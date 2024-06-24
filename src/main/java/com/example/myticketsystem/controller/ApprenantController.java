package com.example.myticketsystem.controller;

import com.example.myticketsystem.entity.Apprenant;
import com.example.myticketsystem.service.ApprenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/apprenants")
public class ApprenantController {

    @Autowired
    private ApprenantService apprenantService;

    @PostMapping("/create")
    public ResponseEntity<Apprenant> createApprenant(@RequestBody Apprenant apprenant) {
        return ResponseEntity.ok(apprenantService.save(apprenant));
    }

    @GetMapping("/read")
    public ResponseEntity<List<Apprenant>> getAllApprenants() {
        return ResponseEntity.ok(apprenantService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Apprenant> getApprenantById(@PathVariable Long id) {
        return apprenantService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Apprenant> updateApprenant(@PathVariable Long id, @RequestBody Apprenant apprenant) {
        apprenant.setId(id);
        return ResponseEntity.ok(apprenantService.save(apprenant));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteApprenant(@PathVariable Long id) {
        apprenantService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
