package com.wine.to.up.catalog.service.repository;

import com.wine.to.up.catalog.service.domain.entities.WineGrapesInfo;
import org.springframework.data.repository.CrudRepository;

public interface WineGrapesInfoRepository extends CrudRepository<WineGrapesInfo, Integer> {
    WineGrapesInfo findByWineID(int wineId);
    WineGrapesInfo findByGrapeID(int grapesID);
}