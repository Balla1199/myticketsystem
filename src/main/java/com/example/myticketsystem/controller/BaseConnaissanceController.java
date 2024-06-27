package com.example.myticketsystem.controller;

import com.example.myticketsystem.entity.BaseConnaissance;
import com.example.myticketsystem.service.BaseConnaissanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/baseconnaissance")
public class BaseConnaissanceController {

    @Autowired
    private BaseConnaissanceService baseConnaissanceService;

    @PostMapping("/create")
    public ResponseEntity<BaseConnaissance> createBaseConnaissance(@RequestBody BaseConnaissance baseConnaissance) {
        BaseConnaissance createdBaseConnaissance = baseConnaissanceService.save(baseConnaissance);
        return ResponseEntity.ok(createdBaseConnaissance);
    }

    @GetMapping("/all")
    public ResponseEntity<List<BaseConnaissance>> getAllBaseConnaissances() {
        List<BaseConnaissance> baseConnaissances = baseConnaissanceService.findAll();
        return ResponseEntity.ok(baseConnaissances);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BaseConnaissance> getBaseConnaissanceById(@PathVariable int id) {
        BaseConnaissance baseConnaissance = baseConnaissanceService.findById(id);
        if (baseConnaissance != null) {
            return ResponseEntity.ok(baseConnaissance);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<BaseConnaissance> updateBaseConnaissance(@RequestBody BaseConnaissance baseConnaissance) {
        BaseConnaissance updatedBaseConnaissance = baseConnaissanceService.update(baseConnaissance);
        return ResponseEntity.ok(updatedBaseConnaissance);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteBaseConnaissance(@PathVariable int id) {
        baseConnaissanceService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
