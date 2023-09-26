package com.ddefilippi.hecho_en_peru_trabalho_3.service;

import com.ddefilippi.hecho_en_peru_trabalho_3.exception.HighlightedEntityException;
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
    public List<Region> saveRegions(List<Region> regions) {

        // If all regions have id = null, save all
        boolean isAllRegionWithIdNull = regions.stream()
                .allMatch(region -> region.getIdRegion() == null);

        
        if (isAllRegionWithIdNull) {
            return regionRepository.saveAll(regions);
        }

        // If any region has id != null, throw exception
        throw new HighlightedEntityException("Trying to save a highlighted object");
    }
    // List categories
    public List<Region> getRegions() {
        return regionRepository.findAll();
    }

}
