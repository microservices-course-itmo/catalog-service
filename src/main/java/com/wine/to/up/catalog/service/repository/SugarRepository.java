package com.wine.to.up.catalog.service.repository;

import com.wine.to.up.catalog.service.domain.entities.Brand;
import com.wine.to.up.catalog.service.domain.entities.Color;
import com.wine.to.up.catalog.service.domain.entities.Sugar;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SugarRepository extends CrudRepository<Sugar, String> {
    Sugar findBySugarID(String sugarId);

    Sugar findBySugarName(String sugarName);
}
