package com.wine.to.up.catalog.service.mapper.controller2service;

import com.wine.to.up.catalog.service.domain.dto.WinePositionDTO;
import com.wine.to.up.catalog.service.domain.request.GrapeRequest;
import com.wine.to.up.catalog.service.domain.request.WinePositionRequest;
import com.wine.to.up.catalog.service.domain.response.GrapeResponse;
import com.wine.to.up.catalog.service.domain.response.WinePositionResponse;
import org.springframework.stereotype.Component;

@Component
public class WinePositionControllerToWinePositionService {
    public WinePositionDTO convert(WinePositionRequest winePositionRequest) {
        WinePositionDTO winePositionDTO = new WinePositionDTO();
        winePositionDTO.setImage(winePositionRequest.getImage());
        winePositionDTO.setGastronomy(winePositionRequest.getGastronomy());
        winePositionDTO.setDescription(winePositionRequest.getDescription());
        winePositionDTO.setVolume(winePositionRequest.getVolume());
        winePositionDTO.setLink_to_wine(winePositionRequest.getLink_to_wine());
        winePositionDTO.setActual_price(winePositionRequest.getActual_price());
        winePositionDTO.setPrice(winePositionRequest.getPrice());
        winePositionDTO.setShop_id(winePositionRequest.getShop_id());
        winePositionDTO.setWine_id(winePositionRequest.getWine_id());
        return winePositionDTO;
    }

    public WinePositionResponse convert(WinePositionDTO winePositionDTO) {
        WinePositionResponse winePositionResponse = new WinePositionResponse();
        winePositionResponse.setActual_price(winePositionDTO.getActual_price());
        winePositionResponse.setDescription(winePositionDTO.getDescription());
        winePositionResponse.setGastronomy(winePositionDTO.getGastronomy());
        winePositionResponse.setImage(winePositionDTO.getImage());
        winePositionResponse.setLink_to_wine(winePositionDTO.getLink_to_wine());
        winePositionResponse.setPrice(winePositionDTO.getPrice());
        winePositionResponse.setShop_id(winePositionDTO.getShop_id());
        winePositionResponse.setVolume(winePositionDTO.getVolume());
        winePositionResponse.setWine_id(winePositionDTO.getWine_id());
        winePositionResponse.setWine_position_id(winePositionDTO.getWine_position_id());
        return winePositionResponse;
    }
}
