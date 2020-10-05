package com.wine.to.up.catalog.service.mapper.service2repository;

import com.google.common.primitives.Bytes;
import com.wine.to.up.catalog.service.domain.dto.WineDTO;
import com.wine.to.up.catalog.service.domain.entities.Wine;
import org.springframework.stereotype.Component;

@Component
public class WineServiceToWineRepository {
    public Wine convert(WineDTO wineDTO) {
        Wine wine = new Wine();

        wine.setStrength(wineDTO.getStrength());
        wine.setVolume(wineDTO.getVolume());
        wine.setName(wineDTO.getName());
        wine.setWineID(wineDTO.getId());
        wine.setProduction_year(wineDTO.getProduction_year());

        byte[] pictureArray = Bytes.toArray(wineDTO.getPicture());
        wine.setPicture(pictureArray);

        return wine;
    }

    public WineDTO convert(Wine wine) {
        WineDTO wineDTO = new WineDTO();
        wineDTO.setWine_chars(null);
        wineDTO.setDiscount_info(null);
        wineDTO.setSugar_content(wine.getSugar().name());
        wineDTO.setColor(wine.getColor().name());
        wineDTO.setProduction_country(wine.getCountry().getCountryName());
        wineDTO.setProduction_year(wine.getProduction_year());
        wineDTO.setPrice(null);
        wineDTO.setName(wine.getName());
        wineDTO.setId(wine.getWineID());
        wineDTO.setVolume(wine.getVolume());
        wineDTO.setStrength(wine.getStrength());
        wineDTO.setPicture(Bytes.asList(wine.getPicture()));
        wineDTO.setBrand(wine.getBrand().getBrandName());
        return wineDTO;
    }
}
