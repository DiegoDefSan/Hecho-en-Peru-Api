package com.ddefilippi.hecho_en_peru_trabalho_3.controllers;

import com.ddefilippi.hecho_en_peru_trabalho_3.model.Handcraft;
import com.ddefilippi.hecho_en_peru_trabalho_3.service.HandcraftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/handcrafts") // http://localhost:8080/handcrafts
public class HandcraftController {

    @Autowired
    private HandcraftService handcraftService;

    @GetMapping
    public List<Handcraft> getHandcrafts() {
        return handcraftService.getHandcrafts();
    }

    @PostMapping("/addHandcrafts")
    public List<Handcraft> addHandcrafts(@RequestBody List<Handcraft> handcraftList) {
        return handcraftService.saveHandcrafts(handcraftList);
    }

}
