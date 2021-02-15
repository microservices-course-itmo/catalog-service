package com.wine.to.up.catalog.service.mapper.service2repository;

import com.wine.to.up.catalog.service.domain.dto.BrandDTO;
import com.wine.to.up.catalog.service.domain.entities.Brand;
import org.springframework.stereotype.Component;

@Component
public class BrandServiceToBrandRepository {
    public Brand convert(BrandDTO brandDTO) {
        Brand brand = new Brand();
        brand.setBrandID(brandDTO.getId());
        brand.setBrandName(brandDTO.getName());
        return brand;
    }

    public BrandDTO convert(Brand brand) {
        BrandDTO brandDTO = new BrandDTO();
        brandDTO.setId(brand.getBrandID());
        brandDTO.setName(brand.getBrandName());
        return brandDTO;

    }
}
