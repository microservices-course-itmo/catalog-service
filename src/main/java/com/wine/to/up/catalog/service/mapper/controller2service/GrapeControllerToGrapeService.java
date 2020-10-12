package com.wine.to.up.catalog.service.mapper.controller2service;

import com.wine.to.up.catalog.service.domain.dto.GrapeDTO;
import com.wine.to.up.catalog.service.domain.entities.Grape;
import com.wine.to.up.catalog.service.domain.request.GrapeRequest;
import com.wine.to.up.catalog.service.domain.response.GrapeResponse;
import org.springframework.stereotype.Component;

@Component
public class GrapeControllerToGrapeService {
    public GrapeDTO convert(GrapeRequest grapeRequest) {
        GrapeDTO grapeDTO = new GrapeDTO();
        grapeDTO.setName(grapeRequest.getName());
        return grapeDTO;
    }

    public GrapeResponse convert(GrapeDTO grapeDTO) {
        GrapeResponse grapeResponse = new GrapeResponse();
        grapeResponse.setName(grapeDTO.getName());
        grapeResponse.setId(grapeDTO.getId());
        return grapeResponse;
    }
}
