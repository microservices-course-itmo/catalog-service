package com.wine.to.up.catalog.service.mapper.controller2service;

import com.wine.to.up.catalog.service.domain.request.BrandRequest;
import com.wine.to.up.catalog.service.domain.response.BrandResponse;
import org.springframework.stereotype.Component;

@Component
public class BrandControllerToBrandService {
    public void convert(BrandRequest brandRequest){

    }

    public BrandResponse convert(){
        return new BrandResponse();
    }
}
