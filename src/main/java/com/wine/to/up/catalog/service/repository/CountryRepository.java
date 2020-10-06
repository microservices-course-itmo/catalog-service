package com.wine.to.up.catalog.service.repository;

import com.wine.to.up.catalog.service.domain.entities.Brand;
import com.wine.to.up.catalog.service.domain.entities.Country;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends CrudRepository<Country, Integer> {
    Country findCountryByCountryID(int countryId);
    List<Country> findCountryByCountryName(String countryName);
}
