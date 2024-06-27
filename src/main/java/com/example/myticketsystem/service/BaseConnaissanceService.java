package com.example.myticketsystem.service;

import com.example.myticketsystem.entity.BaseConnaissance;

import java.util.List;

public interface BaseConnaissanceService {
    BaseConnaissance save(BaseConnaissance baseConnaissance);
    List<BaseConnaissance> findAll();
    BaseConnaissance findById(int id);
    BaseConnaissance update(BaseConnaissance baseConnaissance);
    void deleteById(int id);
}
