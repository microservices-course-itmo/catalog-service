package com.wine.to.up.catalog.service.service;

import com.wine.to.up.catalog.service.domain.dto.RegionDTO;
import com.wine.to.up.catalog.service.mapper.service2repository.RegionServiceToRegionRepository;
import com.wine.to.up.catalog.service.repository.RegionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class RegionService implements BaseCrudService<RegionDTO> {

    private final RegionRepository regionRepository;
    private final RegionServiceToRegionRepository converter;

    @Override
    public List<RegionDTO> readAll() {
        return StreamSupport
                .stream(regionRepository.findAll().spliterator(), false)
                .map(converter::convert)
                .collect(Collectors.toList());
    }

    @Override
    public void create(RegionDTO regionDTO) {
        regionDTO.setId(UUID.randomUUID().toString());
        regionRepository.save(converter.convert(regionDTO));
    }

    @Override
    public RegionDTO read(String id) {
        return converter.convert(regionRepository.findByRegionID(id));
    }

    @Override
    public void update(String id, RegionDTO regionDTO) {
        regionDTO.setId(id);
        regionRepository.save(converter.convert(regionDTO));
    }

    @Override
    public void delete(String id) {
        regionRepository.deleteById(id);
    }
}
