package com.example.myticketsystem.service.impl;

import com.example.myticketsystem.entity.BaseConnaissance;
import com.example.myticketsystem.repository.BaseConnaissanceRepository;
import com.example.myticketsystem.service.BaseConnaissanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaseConnaissanceServiceImpl implements BaseConnaissanceService {

    @Autowired
    private BaseConnaissanceRepository baseConnaissanceRepository;

    @Override
    public BaseConnaissance save(BaseConnaissance baseConnaissance) {
        return baseConnaissanceRepository.save(baseConnaissance);
    }

    @Override
    public List<BaseConnaissance> findAll() {
        return baseConnaissanceRepository.findAll();
    }

    @Override
    public BaseConnaissance findById(int id) {
        return baseConnaissanceRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(int id) {
        baseConnaissanceRepository.deleteById(id);
    }
}
