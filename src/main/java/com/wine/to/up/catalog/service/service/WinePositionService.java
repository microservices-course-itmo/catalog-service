package com.wine.to.up.catalog.service.service;

import com.google.common.primitives.Bytes;
import com.wine.to.up.catalog.service.domain.dto.WinePositionDTO;
import com.wine.to.up.catalog.service.domain.entities.WinePosition;
import com.wine.to.up.catalog.service.repository.ShopRepository;
import com.wine.to.up.catalog.service.repository.WinePositionRepository;
import com.wine.to.up.catalog.service.repository.WineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class WinePositionService implements BaseCrudService<WinePositionDTO> {

    private final WinePositionRepository winePositionRepository;
    private final WineRepository wineRepository;
    private final ShopRepository shopRepository;

    @Override
    public void create(WinePositionDTO winePositionDTO) {
        WinePosition winePosition = new WinePosition();
        winePosition.setId(UUID.randomUUID().toString());
        winePosition.setWpWine(wineRepository.findWineByWineID(winePositionDTO.getWine_id()));
        winePosition.setShop(shopRepository.findByShopID(winePositionDTO.getShop_id()));
        winePosition.setPrice(winePositionDTO.getPrice());
        winePosition.setActual_price(winePositionDTO.getActual_price());
        winePosition.setLinkToWine(winePositionDTO.getLink_to_wine());
        winePosition.setVolume(winePositionDTO.getVolume());
        winePosition.setDescription(winePositionDTO.getDescription());
        winePosition.setGastronomy(winePositionDTO.getGastronomy());
        winePosition.setImage(Bytes.toArray(winePositionDTO.getImage()));
        winePositionRepository.save(winePosition);
    }

    @Override
    public WinePositionDTO read(String id) {
        WinePosition byId = winePositionRepository.findById(id).get();
        WinePositionDTO winePositionDTO = new WinePositionDTO();
        winePositionDTO.setWine_position_id(id);
        winePositionDTO.setWine_id(byId.getWpWine().getWineID());
        winePositionDTO.setShop_id(byId.getShop().getShopID());
        winePositionDTO.setPrice(byId.getPrice());
        winePositionDTO.setActual_price(byId.getActual_price());
        winePositionDTO.setLink_to_wine(byId.getLinkToWine());
        winePositionDTO.setVolume(byId.getVolume());
        winePositionDTO.setDescription(byId.getDescription());
        winePositionDTO.setGastronomy(byId.getGastronomy());
        winePositionDTO.setImage(Bytes.asList(byId.getImage()));
        return winePositionDTO;
    }

    @Override
    public void update(String id, WinePositionDTO winePositionDTO) {
        WinePosition winePosition = new WinePosition();
        winePosition.setId(id);
        winePosition.setWpWine(wineRepository.findWineByWineID(winePositionDTO.getWine_id()));
        winePosition.setShop(shopRepository.findByShopID(winePositionDTO.getShop_id()));
        winePosition.setPrice(winePositionDTO.getPrice());
        winePosition.setActual_price(winePositionDTO.getActual_price());
        winePosition.setLinkToWine(winePositionDTO.getLink_to_wine());
        winePosition.setVolume(winePositionDTO.getVolume());
        winePosition.setDescription(winePositionDTO.getDescription());
        winePosition.setGastronomy(winePositionDTO.getGastronomy());
        winePosition.setImage(Bytes.toArray(winePositionDTO.getImage()));
        winePositionRepository.save(winePosition);
    }

    @Override
    public void delete(String id) {
        winePositionRepository.deleteById(id);
    }
}
