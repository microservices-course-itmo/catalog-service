package com.wine.to.up.catalog.service.repository;

import com.wine.to.up.catalog.service.domain.entities.Catalog;
import com.wine.to.up.catalog.service.domain.entities.Shop;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CatalogRepository extends CrudRepository<Catalog, Integer>{
    Catalog findByWinePositionID(int winePositionID);
    List<Catalog> findAllByShopID(Shop shop);
}