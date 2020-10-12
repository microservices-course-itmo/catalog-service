package com.wine.to.up.catalog.service.service;

import com.wine.to.up.catalog.service.domain.dto.WinePositionTrueDTO;
import com.wine.to.up.catalog.service.repository.WinePositionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WinePositionTrueService implements BaseCrudService<WinePositionTrueDTO> {

    private final WinePositionRepository winePositionRepository;

    @Override
    public void create(WinePositionTrueDTO winePositionTrueDTO) {

    }

    @Override
    public WinePositionTrueDTO read(String id) {
        return null;
    }

    @Override
    public void update(String id, WinePositionTrueDTO winePositionTrueDTO) {

    }

    @Override
    public void delete(String id) {

    }
}
