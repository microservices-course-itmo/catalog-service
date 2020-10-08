package com.wine.to.up.catalog.service.repository;

import com.wine.to.up.catalog.service.domain.entities.Shop;
import com.wine.to.up.catalog.service.domain.entities.Wine;
import com.wine.to.up.catalog.service.domain.entities.WinePosition;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface WinePositionRepository extends PagingAndSortingRepository<WinePosition, String> {
    List<WinePosition> findAllByShop(Shop shop, Pageable pageable);
    List<WinePosition> findAllByWpWine(Wine wine, Pageable pageable);
}
