package com.wine.to.up.catalog.service.mapper.controller2service;

import com.wine.to.up.catalog.service.domain.dto.ProducerDTO;
import com.wine.to.up.catalog.service.domain.request.GrapeRequest;
import com.wine.to.up.catalog.service.domain.request.ProducerRequest;
import com.wine.to.up.catalog.service.domain.response.GrapeResponse;
import com.wine.to.up.catalog.service.domain.response.ProducerResponse;
import org.springframework.stereotype.Component;

@Component
public class ProducerControllerToProducerService {
    public ProducerDTO convert(ProducerRequest producerRequest) {
        ProducerDTO producerDTO = new ProducerDTO();
        producerDTO.setName(producerRequest.getName());
        return producerDTO;
    }

    public ProducerResponse convert(ProducerDTO producerDTO) {
        ProducerResponse producerResponse = new ProducerResponse();
        producerResponse.setId(producerDTO.getId());
        producerResponse.setName(producerDTO.getName());
        return producerResponse;
    }
}
