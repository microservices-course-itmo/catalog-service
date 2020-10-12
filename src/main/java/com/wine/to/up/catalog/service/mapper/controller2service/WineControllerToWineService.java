package com.wine.to.up.catalog.service.mapper.controller2service;

import com.wine.to.up.catalog.service.domain.dto.WineDTO;
import com.wine.to.up.catalog.service.domain.request.WineRequest;
import com.wine.to.up.catalog.service.domain.response.WineResponse;
import org.springframework.stereotype.Component;

@Component
public class WineControllerToWineService {
    public WineDTO convert(WineRequest wineRequest) {
        WineDTO wineDTO = new WineDTO();
        wineDTO.setSugar(wineRequest.getSugar());
        wineDTO.setColor(wineRequest.getColor());
        wineDTO.setYear(wineRequest.getYear());
        wineDTO.setAvg(wineRequest.getAvg());
        wineDTO.setGrape_id(wineRequest.getGrape_id());
        wineDTO.setRegion_id(wineRequest.getRegion_id());
        wineDTO.setBrand_id(wineRequest.getBrand_id());
        wineDTO.setProducer_id(wineRequest.getProducer_id());
        wineDTO.setName(wineRequest.getName());
        return wineDTO;
    }

    public WineResponse convert(WineDTO wineDTO)
    {
        WineResponse wineResponse = new WineResponse();
        wineResponse.setAvg(wineDTO.getAvg());
        wineResponse.setBrand_id(wineDTO.getBrand_id());
        wineResponse.setColor(wineDTO.getColor());
        wineResponse.setGrape_id(wineDTO.getGrape_id());
        wineResponse.setName(wineDTO.getName());
        wineResponse.setProducer_id(wineDTO.getProducer_id());
        wineResponse.setRegion_id(wineDTO.getRegion_id());
        wineResponse.setSugar(wineDTO.getSugar());
        wineResponse.setWine_id(wineDTO.getId());
        wineResponse.setYear(wineDTO.getYear());
        return wineResponse;
    }
}
