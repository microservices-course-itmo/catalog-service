package com.wine.to.up.catalog.service.mapper.service2repository;

import com.wine.to.up.catalog.service.domain.dto.ShopDTO;
import com.wine.to.up.catalog.service.domain.entities.Shop;
import org.springframework.stereotype.Component;

@Component
public class ShopServiceToShopRepository {
    public ShopDTO convert(Shop shop) {
        ShopDTO shopDTO = new ShopDTO();
        shopDTO.setId(shop.getShopID());
        shopDTO.setSite(shop.getShopSite());
        return shopDTO;
    }

    public Shop convert(ShopDTO shopDTO) {
        Shop shop = new Shop();
        shop.setShopID(shopDTO.getId());
        shop.setShopSite(shopDTO.getSite());
        return shop;
    }
}
