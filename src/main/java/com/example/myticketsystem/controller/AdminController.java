package com.example.myticketsystem.controller;

import com.example.myticketsystem.entity.Admin;
import com.example.myticketsystem.service.AdminService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@Tag(name = "admin controller",description = "controlleur d'admin")
@RestController
@RequestMapping("/api/admins")
public class AdminController {

    @Autowired
    private AdminService adminService;
    @Operation(summary = "lister tous les admin",description = "afficher la liste d'admin")
    @GetMapping("/read")
    public ResponseEntity<List<Admin>> getAllAdmins() {
        List<Admin> admins = adminService.findAll();
        return new ResponseEntity<>(admins, HttpStatus.OK);
    }

    @Operation(summary = "rechercher admin par id",description = "rechercher un admin")
    @GetMapping("/{id}")
    public ResponseEntity<Admin> getAdminById(@PathVariable("id") Long id) {
        Optional<Admin> admin = adminService.findById(id);
        return admin.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "creer admin",description = "la creation d'admin")
    @PostMapping("/create")
    public ResponseEntity<Admin> createAdmin(@RequestBody Admin admin) {
        Admin createdAdmin = adminService.save(admin);
        return new ResponseEntity<>(createdAdmin, HttpStatus.CREATED);
    }

    @Operation(summary = "modifier admin",description = "la modification d'amin ")
    @PutMapping("/{id}")
    public ResponseEntity<Admin> updateAdmin(@PathVariable("id") Long id, @RequestBody Admin admin) {
        admin.setId(id);
        Admin updatedAdmin = adminService.update(admin);
        return new ResponseEntity<>(updatedAdmin, HttpStatus.OK);
    }

    @Operation(summary = "supprimer admin",description = "la suppression d'admin")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable("id") Long id) {
        adminService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
