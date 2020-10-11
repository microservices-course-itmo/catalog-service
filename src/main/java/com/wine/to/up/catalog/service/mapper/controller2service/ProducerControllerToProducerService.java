package com.wine.to.up.catalog.service.mapper.controller2service;

import com.wine.to.up.catalog.service.domain.request.GrapeRequest;
import com.wine.to.up.catalog.service.domain.request.ProducerRequest;
import com.wine.to.up.catalog.service.domain.response.GrapeResponse;
import com.wine.to.up.catalog.service.domain.response.ProducerResponse;
import org.springframework.stereotype.Component;

@Component
public class ProducerControllerToProducerService {
    public void convert(ProducerRequest producerRequest) {
    }

    public ProducerResponse convert() {
        return new ProducerResponse();
    }
}
