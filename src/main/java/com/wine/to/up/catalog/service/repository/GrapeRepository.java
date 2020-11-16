package com.wine.to.up.catalog.service.repository;

import com.wine.to.up.catalog.service.domain.entities.Grape;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrapeRepository extends CrudRepository<Grape, String> {
    Grape findByGrapeID(String grapeID);
    Grape findByGrapeName(String name);
}
