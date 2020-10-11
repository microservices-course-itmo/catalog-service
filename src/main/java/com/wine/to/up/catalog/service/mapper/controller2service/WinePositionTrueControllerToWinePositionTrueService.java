package com.wine.to.up.catalog.service.mapper.controller2service;

import com.wine.to.up.catalog.service.domain.request.GrapeRequest;
import com.wine.to.up.catalog.service.domain.request.WinePositionTrueRequest;
import com.wine.to.up.catalog.service.domain.response.GrapeResponse;
import com.wine.to.up.catalog.service.domain.response.WinePositionTrueResponse;
import org.springframework.stereotype.Component;

@Component
public class WinePositionTrueControllerToWinePositionTrueService {
    public void convert(WinePositionTrueRequest winePositionTrueRequest) {
    }

    public WinePositionTrueResponse convert() {
        return new WinePositionTrueResponse();
    }
}
