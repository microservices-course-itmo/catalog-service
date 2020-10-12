package com.wine.to.up.catalog.service.mapper.controller2service;

import com.wine.to.up.catalog.service.domain.dto.BrandDTO;
import com.wine.to.up.catalog.service.domain.request.BrandRequest;
import com.wine.to.up.catalog.service.domain.response.BrandResponse;
import org.springframework.stereotype.Component;

@Component
public class BrandControllerToBrandService {
    public BrandDTO convert(BrandRequest brandRequest){
        BrandDTO brandDTO = new BrandDTO();
        brandDTO.setName(brandRequest.getName());
        return brandDTO;
    }

    public BrandResponse convert(BrandDTO brandDTO){
        BrandResponse brandResponse = new BrandResponse();
        brandResponse.setId(brandDTO.getId());
        brandResponse.setName(brandDTO.getName());
        return brandResponse;
    }
}
