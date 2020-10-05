package com.wine.to.up.catalog.service.repository;

import com.wine.to.up.catalog.service.domain.entities.Price;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionPriceRepository extends CrudRepository<Price, Integer> {
}
