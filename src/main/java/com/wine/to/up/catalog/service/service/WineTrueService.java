package com.wine.to.up.catalog.service.service;

import com.wine.to.up.catalog.service.domain.dto.WineTrueDTO;
import com.wine.to.up.catalog.service.repository.WineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WineTrueService implements BaseCrudService<WineTrueDTO> {

    private final WineRepository wineRepository;

    @Override
    public void create(WineTrueDTO wineTrueDTO) {

    }

    @Override
    public WineTrueDTO read(String id) {
        return null;
    }

    @Override
    public void update(String id, WineTrueDTO wineTrueDTO) {

    }

    @Override
    public void delete(String id) {

    }
}
