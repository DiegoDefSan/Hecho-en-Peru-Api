package com.ddefilippi.hecho_en_peru_trabalho_3.service;

import com.ddefilippi.hecho_en_peru_trabalho_3.model.Region;
import com.ddefilippi.hecho_en_peru_trabalho_3.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionService {

    @Autowired
    private RegionRepository regionRepository;

    // Save categories
    public List<Region> saveCategories(List<Region> regions) {
        return regionRepository.saveAll(regions);
    }
    // List categories
    public List<Region> getCategories() {
        return regionRepository.findAll();
    }

}
