package com.wine.to.up.catalog.service.mapper.service2repository;

import com.wine.to.up.catalog.service.domain.dto.ProducerDTO;
import com.wine.to.up.catalog.service.domain.entities.Producer;
import org.springframework.stereotype.Component;

@Component
public class ProducerServiceToProducerRepository {
    public Producer convert(ProducerDTO producerDTO){
        Producer producer = new Producer();
        producer.setProducerID(producerDTO.getId());
        producer.setProducerName(producerDTO.getName());
        return producer;

    }
    public ProducerDTO convert(Producer producer){
        ProducerDTO producerDTO = new ProducerDTO();
        producerDTO.setId(producer.getProducerID());
        producerDTO.setName(producer.getProducerName());
        return producerDTO;
    }
}
