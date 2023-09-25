package com.ddefilippi.hecho_en_peru_trabalho_3.controllers;

import com.ddefilippi.hecho_en_peru_trabalho_3.model.Region;
import com.ddefilippi.hecho_en_peru_trabalho_3.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/regions") // http://localhost:8080/regions
public class RegionController {

    @Autowired
    private RegionService regionService;

    @GetMapping
    public List<Region> getRegions() {
        return regionService.getRegions();
    }

    @PostMapping
    public List<Region> saveRegions(List<Region> regions) {
        return regionService.saveRegions(regions);
    }
}
