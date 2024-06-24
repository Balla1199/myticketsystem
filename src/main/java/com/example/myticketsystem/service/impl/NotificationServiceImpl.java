package com.example.myticketsystem.service.impl;

import com.example.myticketsystem.entity.Notification;
import com.example.myticketsystem.repository.NotificationRepository;
import com.example.myticketsystem.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    @Override
    public Notification save(Notification notification) {
        return notificationRepository.save(notification);
    }

    @Override
    public List<Notification> findAll() {
        return notificationRepository.findAll();
    }

    @Override
    public List<Notification> findByUserId(Long userId) {
        return notificationRepository.findByUserId(userId);
    }
}
