package com.wine.to.up.catalog.service.repository;

import com.wine.to.up.catalog.service.domain.entities.Brand;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandRepository extends CrudRepository<Brand, String> {
    Brand findBrandsByBrandID(String brandId);
    List<Brand> findBrandByBrandName(String brandName);
}
