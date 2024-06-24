package com.example.myticketsystem.service.impl;

import com.example.myticketsystem.entity.Response;
import com.example.myticketsystem.repository.ResponseRepository;
import com.example.myticketsystem.service.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResponseServiceImpl implements ResponseService {

    @Autowired
    private ResponseRepository responseRepository;

    @Override
    public Response save(Response response) {
        return responseRepository.save(response);
    }

    @Override
    public List<Response> findAllByTicketId(Long ticketId) {
        return responseRepository.findByTicketId(ticketId);
    }

    @Override
    public Response findById(Long id) {
        Optional<Response> optionalResponse = responseRepository.findById(id);
        return optionalResponse.orElse(null);
    }

    @Override
    public Response update(Response response) {
        // Assuming response is already managed (exists in DB)
        return responseRepository.save(response);
    }

    @Override
    public void deleteById(Long id) {
        responseRepository.deleteById(id);
    }
}
