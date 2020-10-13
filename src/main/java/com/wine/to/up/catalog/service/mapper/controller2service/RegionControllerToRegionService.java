package com.wine.to.up.catalog.service.mapper.controller2service;

import com.wine.to.up.catalog.service.domain.dto.RegionDTO;
import com.wine.to.up.catalog.service.domain.request.GrapeRequest;
import com.wine.to.up.catalog.service.domain.request.RegionRequest;
import com.wine.to.up.catalog.service.domain.response.GrapeResponse;
import com.wine.to.up.catalog.service.domain.response.RegionResponse;
import org.springframework.stereotype.Component;

@Component
public class RegionControllerToRegionService {
    public RegionDTO convert(RegionRequest regionRequest) {
        RegionDTO regionDTO = new RegionDTO();
        regionDTO.setCountry(regionRequest.getCountry());
        regionDTO.setName(regionRequest.getName());
        return regionDTO;
    }

    public RegionResponse convert(RegionDTO regionDTO)
    {
        RegionResponse regionResponse = new RegionResponse();
        regionResponse.setCountry(regionDTO.getCountry());
        regionResponse.setName(regionDTO.getName());
        regionResponse.setId(regionDTO.getId());
        return regionResponse;
    }
}
