package com.ddefilippi.hecho_en_peru_trabalho_3.service;

import com.ddefilippi.hecho_en_peru_trabalho_3.exception.HighlightedEntityException;
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

    public List<Handcraft> saveHandcrafts(List<Handcraft> handcraftList) {

        // If all handcrafts have id = null, save all
        boolean isAllHandcraftWithIdNull = handcraftList.stream()
                .allMatch(handcraft -> handcraft.getIdHandcraft() == null);

        if (isAllHandcraftWithIdNull) {
            return handcraftRepository.saveAll(handcraftList);
        }

        // If any handcraft has id != null, throw exception
        throw new HighlightedEntityException("Trying to save a highlighted object");
    }
}
