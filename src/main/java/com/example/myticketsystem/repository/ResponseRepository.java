package com.example.myticketsystem.repository;

import com.example.myticketsystem.entity.Response;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResponseRepository extends JpaRepository<Response, Long> {
    List<Response> findByTicketId(Long ticketId);
}
