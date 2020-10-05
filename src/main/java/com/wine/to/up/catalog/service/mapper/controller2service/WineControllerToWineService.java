package com.wine.to.up.catalog.service.mapper.controller2service;

import com.wine.to.up.catalog.service.domain.dto.WineDTO;
import com.wine.to.up.catalog.service.domain.request.WinePositionRequest;
import com.wine.to.up.catalog.service.domain.response.WinePositionResponse;
import org.springframework.stereotype.Component;

@Component
public class WineControllerToWineService {
    public WineDTO convert(WinePositionRequest winePositionRequest) {
        WineDTO wineDTO = new WineDTO();
        wineDTO.setName(winePositionRequest.getName());
        wineDTO.setPrice(winePositionRequest.getPrice());
        wineDTO.setProduction_year(winePositionRequest.getProduction_year());
        wineDTO.setProduction_country(winePositionRequest.getProduction_country());
        wineDTO.setSugar_content(winePositionRequest.getSugar_content());
        wineDTO.setDiscount_info(winePositionRequest.getDiscount_info());
        wineDTO.setWine_chars(winePositionRequest.getWine_chars());
        wineDTO.setStrength(winePositionRequest.getStrength());
        wineDTO.setVolume(winePositionRequest.getVolume());
        wineDTO.setColor(winePositionRequest.getColor());
        wineDTO.setBrand(winePositionRequest.getBrand());
        wineDTO.setPicture(winePositionRequest.getPicture());
        return wineDTO;
    }

    public WinePositionResponse convert(WineDTO wineDTO) {
        WinePositionResponse winePositionResponse = new WinePositionResponse();
        winePositionResponse.setId(wineDTO.getId());
        winePositionResponse.setName(wineDTO.getName());
        winePositionResponse.setPrice(wineDTO.getPrice());
        winePositionResponse.setProduction_year(wineDTO.getProduction_year());
        winePositionResponse.setProduction_country(wineDTO.getProduction_country());
        winePositionResponse.setSugar_content(wineDTO.getSugar_content());
        winePositionResponse.setDiscount_info(wineDTO.getDiscount_info());
        winePositionResponse.setWine_chars(wineDTO.getWine_chars());
        winePositionResponse.setStrength(wineDTO.getStrength());
        winePositionResponse.setVolume(wineDTO.getVolume());
        winePositionResponse.setColor(wineDTO.getColor());
        winePositionResponse.setBrand(wineDTO.getBrand());
        winePositionResponse.setPicture(wineDTO.getPicture());
        return winePositionResponse;
    }

}
