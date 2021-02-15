package com.wine.to.up.catalog.service.mapper.service2repository;

import com.wine.to.up.catalog.service.domain.dto.RegionDTO;
import com.wine.to.up.catalog.service.domain.entities.Region;
import org.springframework.stereotype.Component;

@Component
public class RegionServiceToRegionRepository {
    public Region convert(RegionDTO regionDTO){
        Region region = new Region();
        region.setRegionID(regionDTO.getId());
        region.setRegionCountry(regionDTO.getCountry());
        region.setRegionName(regionDTO.getName());
        return region;
    }

    public RegionDTO convert(Region region){
        RegionDTO regionDTO = new RegionDTO();
        regionDTO.setId(region.getRegionID());
        regionDTO.setName(region.getRegionName());
        regionDTO.setCountry(region.getRegionCountry());
        return regionDTO;
    }

}
