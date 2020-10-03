package com.wine.to.up.catalog.service.repository;

import com.wine.to.up.catalog.service.domain.entities.Shop;
import org.springframework.data.repository.CrudRepository;

public interface ShopRepository extends CrudRepository<Shop, Integer> {
    Shop findByShopID(int shopId);
    Shop findByShopName(String shopName);
}
