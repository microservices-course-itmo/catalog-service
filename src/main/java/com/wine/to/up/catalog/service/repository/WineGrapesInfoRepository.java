package com.wine.to.up.catalog.service.repository;

import com.wine.to.up.catalog.service.domain.entities.WinePosition;
import org.springframework.data.repository.CrudRepository;

public interface WineGrapesInfoRepository extends CrudRepository<WinePosition, Integer> {
    WinePosition findByWineID(int wineId);
    WinePosition findByGrapeID(int grapesID);
}