package com.wine.to.up.catalog.service.mapper.controller2service;

import com.wine.to.up.catalog.service.domain.request.GrapeRequest;
import com.wine.to.up.catalog.service.domain.request.RegionRequest;
import com.wine.to.up.catalog.service.domain.response.GrapeResponse;
import com.wine.to.up.catalog.service.domain.response.RegionResponse;
import org.springframework.stereotype.Component;

@Component
public class RegionControllerToRegionService {
    public void convert(RegionRequest regionRequest) {
    }

    public RegionResponse convert() {
        return new RegionResponse();
    }
}
