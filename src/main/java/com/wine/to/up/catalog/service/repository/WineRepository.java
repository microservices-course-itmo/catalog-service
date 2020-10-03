package com.wine.to.up.catalog.service.repository;

import com.wine.to.up.catalog.service.domain.entities.Wine;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface WineRepository extends CrudRepository<Wine, Integer> {
    Wine findWineBywineID(int wineID);
}
