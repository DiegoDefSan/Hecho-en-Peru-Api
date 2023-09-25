package com.ddefilippi.hecho_en_peru_trabalho_3.service;

import com.ddefilippi.hecho_en_peru_trabalho_3.model.Category;
import com.ddefilippi.hecho_en_peru_trabalho_3.model.Handcraft;
import com.ddefilippi.hecho_en_peru_trabalho_3.repository.CategoryRepository;
import com.ddefilippi.hecho_en_peru_trabalho_3.repository.HandcraftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HandcraftService {

    @Autowired
    private HandcraftRepository handcraftRepository;

    public List<Handcraft> getHandcrafts() {
        return handcraftRepository.findAll();
    }
    // Save categories
    public List<Handcraft> saveHandcrafts(List<Handcraft> handcraftList) {
        return handcraftRepository.saveAll(handcraftList);
    }
    // List categories



}
