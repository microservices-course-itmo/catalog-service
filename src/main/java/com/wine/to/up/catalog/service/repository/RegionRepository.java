package com.wine.to.up.catalog.service.repository;

import com.wine.to.up.catalog.service.domain.entities.Region;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegionRepository extends CrudRepository<Region, String> {
    Region findByRegionID(String regionID);
    List<Region> findAllByRegionCountry(String regionCountry);
}
