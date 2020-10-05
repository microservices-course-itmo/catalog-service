package com.wine.to.up.catalog.service.service;

import com.wine.to.up.catalog.service.domain.dto.GrapeDTO;
import com.wine.to.up.catalog.service.domain.entities.Grape;
import com.wine.to.up.catalog.service.mapper.service2repository.GrapeServiceToGrapeRepository;
import com.wine.to.up.catalog.service.repository.GrapeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class GrapeManagerService {

    private final GrapeRepository grapeRepository;
    private final GrapeServiceToGrapeRepository converter;

    public GrapeDTO getGrapeById(String id) {
        return converter.convert(grapeRepository.findById(id).get());
    }

    public List<GrapeDTO> getAllGrapes() {
        return StreamSupport
                .stream(grapeRepository.findAll().spliterator(), false)
                .map(converter::convert)
                .collect(Collectors.toList());
    }

    public void updateGrape(String id, GrapeDTO grapeDTO) {
        Grape convert = converter.convert(grapeDTO);
        convert.setId(id);
        grapeRepository.save(convert);
    }

    public void createGrape(GrapeDTO grapeDTO) {
        Grape convert = converter.convert(grapeDTO);
        convert.setId(UUID.randomUUID().toString());
        grapeRepository.save(convert);
    }
}
