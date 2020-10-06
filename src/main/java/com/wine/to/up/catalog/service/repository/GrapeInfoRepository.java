package com.wine.to.up.catalog.service.repository;

import com.wine.to.up.catalog.service.domain.entities.WinePosition;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrapeInfoRepository extends CrudRepository<WinePosition, Integer> {
}
