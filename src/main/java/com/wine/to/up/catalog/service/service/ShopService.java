package com.wine.to.up.catalog.service.service;

import com.wine.to.up.catalog.service.domain.dto.ShopDTO;
import com.wine.to.up.catalog.service.mapper.service2repository.ShopServiceToShopRepository;
import com.wine.to.up.catalog.service.repository.ShopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class ShopService implements BaseCrudService<ShopDTO> {

    private final ShopRepository shopRepository;
    private final ShopServiceToShopRepository converter;

    @Override
    public List<ShopDTO> readAll() {
        return StreamSupport
                .stream(shopRepository.findAll().spliterator(), false)
                .map(converter::convert)
                .collect(Collectors.toList());
    }

    @Override
    public void create(ShopDTO shopDTO) {
        shopDTO.setId(UUID.randomUUID().toString());
        shopRepository.save(converter.convert(shopDTO));
    }

    @Override
    public ShopDTO read(String id) {
        return converter.convert(shopRepository.findByShopID(id));
    }

    @Override
    public void update(String id, ShopDTO shopDTO) {
        shopDTO.setId(id);
        shopRepository.save(converter.convert(shopDTO));
    }

    @Override
    public void delete(String id) {
        shopRepository.deleteById(id);
    }
}
