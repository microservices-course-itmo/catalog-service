package com.wine.to.up.demo.service.repository;

import com.wine.to.up.demo.service.domain.entities.Brand;
import com.wine.to.up.demo.service.domain.entities.Wine;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends CrudRepository<Brand, Integer> {
    Brand findBrandsByBrandID(int brandId);
    Brand findBrandByBrandName(String brandName);
}
