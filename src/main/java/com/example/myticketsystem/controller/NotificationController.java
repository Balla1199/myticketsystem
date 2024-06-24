package com.example.myticketsystem.controller;

import com.example.myticketsystem.entity.Notification;
import com.example.myticketsystem.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {
    @Autowired
    private NotificationService notificationService;

    @GetMapping("/{userId}")
    public ResponseEntity<List<Notification>> getNotificationsByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(notificationService.findByUserId(userId));
    }
}
