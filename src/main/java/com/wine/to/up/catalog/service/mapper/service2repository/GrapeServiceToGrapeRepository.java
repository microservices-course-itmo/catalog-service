package com.wine.to.up.catalog.service.mapper.service2repository;

import com.wine.to.up.catalog.service.domain.dto.GrapeDTO;
import com.wine.to.up.catalog.service.domain.entities.Grape;
import org.springframework.stereotype.Component;

@Component
public class GrapeServiceToGrapeRepository {
    public Grape convert(GrapeDTO grapeDTO) {
        Grape grape = new Grape();
        grape.setGrapeID(grapeDTO.getId());
        grape.setGrapeName(grapeDTO.getName());
        return grape;
    }

    public GrapeDTO convert(Grape grape) {
        GrapeDTO grapeDTO = new GrapeDTO();
        grapeDTO.setId(grape.getGrapeID());
        grapeDTO.setName(grape.getGrapeName());
        return grapeDTO;
    }
}
