package com.wine.to.up.catalog.service.mapper.controller2service;

import com.wine.to.up.catalog.service.domain.request.GrapeRequest;
import com.wine.to.up.catalog.service.domain.request.WinePositionRequest;
import com.wine.to.up.catalog.service.domain.response.GrapeResponse;
import com.wine.to.up.catalog.service.domain.response.WinePositionResponse;
import org.springframework.stereotype.Component;

@Component
public class WinePositionControllerToWinePositionService {
    public void convert(WinePositionRequest winePositionRequest) {
    }

    public WinePositionResponse convert() {
        return new WinePositionResponse();
    }
}
