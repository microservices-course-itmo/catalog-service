package com.wine.to.up.catalog.service.repository;

import com.wine.to.up.catalog.service.domain.entities.Country;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends CrudRepository<Country, Integer> {
    Country findByCountryID(int countryID);
    Country findByCountryName(String countryName);
}