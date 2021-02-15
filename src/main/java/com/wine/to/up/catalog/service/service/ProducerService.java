package com.wine.to.up.catalog.service.service;

import com.wine.to.up.catalog.service.domain.dto.ProducerDTO;
import com.wine.to.up.catalog.service.mapper.service2repository.ProducerServiceToProducerRepository;
import com.wine.to.up.catalog.service.repository.ProducerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class ProducerService implements BaseCrudService<ProducerDTO> {

    private final ProducerRepository producerRepository;
    private final ProducerServiceToProducerRepository converter;

    @Override
    public List<ProducerDTO> readAll() {
        return StreamSupport
                .stream(producerRepository.findAll().spliterator(), false)
                .map(converter::convert)
                .collect(Collectors.toList());
    }

    @Override
    public void create(ProducerDTO producerDTO) {
        producerDTO.setId(UUID.randomUUID().toString());
        producerRepository.save(converter.convert(producerDTO));
    }

    @Override
    public ProducerDTO read(String id) {
        return converter.convert(producerRepository.findByProducerID(id));

    }

    @Override
    public void update(String id, ProducerDTO producerDTO) {
        producerDTO.setId(id);
        producerRepository.save(converter.convert(producerDTO));
    }

    @Override
    public void delete(String id) {
        producerRepository.deleteById(id);
    }
}
