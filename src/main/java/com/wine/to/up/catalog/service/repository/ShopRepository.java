package com.wine.to.up.catalog.service.repository;

import com.wine.to.up.catalog.service.domain.entities.Shop;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopRepository extends CrudRepository<Shop, String> {
    Shop findByShopID(String shopId);
}
