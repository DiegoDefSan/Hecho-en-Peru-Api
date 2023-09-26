package com.ddefilippi.hecho_en_peru_trabalho_3.controllers;

import com.ddefilippi.hecho_en_peru_trabalho_3.model.Region;
import com.ddefilippi.hecho_en_peru_trabalho_3.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/regions") // http://localhost:8080/regions
public class RegionController {

    @Autowired
    private RegionService regionService;

    @PostMapping("/addRegions")
    public List<Region> addRegions(@RequestBody List<Region> regions) {
        return regionService.saveRegions(regions);
    }

    @GetMapping
    public List<Region> getRegions() {
        return regionService.getRegions();
    }


}
