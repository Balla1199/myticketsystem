package com.example.myticketsystem.service;

import com.example.myticketsystem.entity.Response;

import java.util.List;

public interface ResponseService {
    Response save(Response response);
    List<Response> findAllByTicketId(Long ticketId);
    Response findById(Long id);
    Response update(Response response);
    void deleteById(Long id);
}
