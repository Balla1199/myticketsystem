package com.example.myticketsystem.service;

import com.example.myticketsystem.entity.Notification;

import java.util.List;

public interface NotificationService {
    Notification save(Notification notification);
    List<Notification> findAll();
    List<Notification> findByUserId(Long userId);
}
