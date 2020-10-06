package com.wine.to.up.catalog.service.repository;

import com.wine.to.up.catalog.service.domain.entities.WineGrapesInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrapeInfoRepository extends CrudRepository<WineGrapesInfo, Integer> {
}
