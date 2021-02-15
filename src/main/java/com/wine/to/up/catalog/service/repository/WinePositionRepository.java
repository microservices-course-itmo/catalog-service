package com.wine.to.up.catalog.service.repository;

import com.wine.to.up.catalog.service.domain.entities.Shop;
import com.wine.to.up.catalog.service.domain.entities.Wine;
import com.wine.to.up.catalog.service.domain.entities.WinePosition;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WinePositionRepository extends PagingAndSortingRepository<WinePosition, String>, JpaSpecificationExecutor<WinePosition> {
    List<WinePosition> findAllByShop(Shop shop, Pageable pageable);
    List<WinePosition> findAllByWpWine(Wine wine, Pageable pageable);
    WinePosition findByWpId(String id);

}
