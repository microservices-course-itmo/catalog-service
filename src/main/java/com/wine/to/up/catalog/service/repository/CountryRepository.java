package com.wine.to.up.catalog.service.repository;

import com.wine.to.up.catalog.service.domain.entities.Region;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends CrudRepository<Region, Integer> {
    Region findCountryByCountryID(int countryId);
    List<Region> findCountryByCountryName(String countryName);
}
