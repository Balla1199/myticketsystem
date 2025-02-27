package com.example.myticketsystem.repository;

import com.example.myticketsystem.entity.Response;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResponseRepository extends JpaRepository<Response, Long> {
    List<Response> findByTicketId(Long ticketId);
}
