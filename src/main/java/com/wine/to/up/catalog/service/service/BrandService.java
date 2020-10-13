package com.wine.to.up.catalog.service.service;

import com.wine.to.up.catalog.service.domain.dto.BrandDTO;
import com.wine.to.up.catalog.service.mapper.service2repository.BrandServiceToBrandRepository;
import com.wine.to.up.catalog.service.repository.BrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class BrandService implements BaseCrudService<BrandDTO> {

    private final BrandRepository brandRepository;
    private final BrandServiceToBrandRepository converter;

    @Override
    public List<BrandDTO> readAll() {
        return StreamSupport
                .stream(brandRepository.findAll().spliterator(), false)
                .map(converter::convert)
                .collect(Collectors.toList());
    }

    @Override
    public void create(BrandDTO brandDTO) {
        brandDTO.setId(UUID.randomUUID().toString());
        brandRepository.save(converter.convert(brandDTO));
    }

    @Override
    public BrandDTO read(String id) {
        return converter.convert(brandRepository.findById(id).get());
    }

    @Override
    public void update(String id, BrandDTO brandDTO) {
        brandDTO.setId(id);
        brandRepository.save(converter.convert(brandDTO));
    }

    @Override
    public void delete(String id) {
        brandRepository.deleteById(id);
    }
}
