package com.wine.to.up.catalog.service.repository;

import com.wine.to.up.catalog.service.domain.entities.Producer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProducerRepository extends CrudRepository<Producer, String> {
    Producer findByProducerID(String producerID);
    Producer findByProducerName(String name);
}
