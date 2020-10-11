package com.wine.to.up.catalog.service.mapper.controller2service;

import com.wine.to.up.catalog.service.domain.dto.GrapeDTO;
import com.wine.to.up.catalog.service.domain.request.GrapeRequest;
import com.wine.to.up.catalog.service.domain.response.GrapeResponse;
import org.springframework.stereotype.Component;

@Component
public class GrapeControllerToGrapeService {
    public void convert(GrapeRequest grapeRequest) {
    }

    public GrapeResponse convert() {
        return new GrapeResponse();
    }
}
