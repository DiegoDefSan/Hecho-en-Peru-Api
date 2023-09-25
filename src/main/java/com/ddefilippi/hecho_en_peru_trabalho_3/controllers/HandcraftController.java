package com.ddefilippi.hecho_en_peru_trabalho_3.controllers;

import com.ddefilippi.hecho_en_peru_trabalho_3.model.Handcraft;
import com.ddefilippi.hecho_en_peru_trabalho_3.service.HandcraftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HandcraftController {

    @Autowired
    private HandcraftService handcraftService;

    public List<Handcraft> getHandcrafts() {
        return handcraftService.getHandcrafts();
    }

    public List<Handcraft> saveHandcrafts(List<Handcraft> handcraftList) {
        return handcraftService.saveHandcrafts(handcraftList);
    }

}
