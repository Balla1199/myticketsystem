package com.example.myticketsystem.controller;

import com.example.myticketsystem.entity.BaseConnaissance;
import com.example.myticketsystem.service.BaseConnaissanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/base-connaissances")
public class BaseConnaissanceController {

    @Autowired
    private BaseConnaissanceService baseConnaissanceService;

    @PostMapping("/create")
    public ResponseEntity<BaseConnaissance> createBaseConnaissance(@RequestBody BaseConnaissance baseConnaissance) {
        return ResponseEntity.ok(baseConnaissanceService.save(baseConnaissance));
    }

    @GetMapping("/read")
    public ResponseEntity<List<BaseConnaissance>> getAllBaseConnaissances() {
        return ResponseEntity.ok(baseConnaissanceService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BaseConnaissance> getBaseConnaissanceById(@PathVariable int id) {
        return ResponseEntity.ok(baseConnaissanceService.findById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<BaseConnaissance> updateBaseConnaissance(@PathVariable int id, @RequestBody BaseConnaissance baseConnaissance) {
        baseConnaissance.setId(id);
        return ResponseEntity.ok(baseConnaissanceService.save(baseConnaissance));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteBaseConnaissance(@PathVariable int id) {
        baseConnaissanceService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
