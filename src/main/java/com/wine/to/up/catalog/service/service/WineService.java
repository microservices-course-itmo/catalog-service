package com.wine.to.up.catalog.service.service;

import com.google.common.primitives.Bytes;
import com.wine.to.up.catalog.service.domain.dto.WineDTO;
import com.wine.to.up.catalog.service.domain.dto.WinePositionDTO;
import com.wine.to.up.catalog.service.domain.entities.Wine;
import com.wine.to.up.catalog.service.domain.entities.WinePosition;
import com.wine.to.up.catalog.service.domain.enums.Color;
import com.wine.to.up.catalog.service.domain.enums.Sugar;
import com.wine.to.up.catalog.service.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class WineService implements BaseCrudService<WineDTO> {

    private final WineRepository wineRepository;
    private final ProducerRepository producerRepository;
    private final BrandRepository brandRepository;
    private final RegionRepository regionRepository;
    private final GrapeRepository grapeRepository;

    @Override
    public List<WineDTO> readAll() {
        return StreamSupport
                .stream(wineRepository.findAll().spliterator(), false)
                .map(new Function<Wine, WineDTO>() {
                    @Override
                    public WineDTO apply(Wine wine) {
                        WineDTO wineDTO = new WineDTO();
                        wineDTO.setId(wine.getWineID());
                        wineDTO.setName(wine.getWineName());
                        wineDTO.setProducer_id(wine.getWineProducer().getProducerID());
                        wineDTO.setBrand_id(wine.getWineBrand().getBrandID());
                        wineDTO.setRegion_id(wine.getWineRegion().getRegionID());
                        wineDTO.setGrape_id(wine.getWineGrape().getGrapeID());
                        wineDTO.setAvg(wine.getStrength());
                        wineDTO.setYear(wine.getProduction_year());
                        wineDTO.setColor(wine.getWineColor().name());
                        wineDTO.setSugar(wine.getWineSugar().name());
                        return wineDTO;
                    }
                })
                .collect(Collectors.toList());
    }

    @Override
    public void create(WineDTO wineDTO) {
        Wine wine = new Wine();
        wine.setWineID(UUID.randomUUID().toString());
        wine.setWineName(wineDTO.getName());
        wine.setWineProducer(producerRepository.findByProducerID(wineDTO.getProducer_id()));
        wine.setWineBrand(brandRepository.findBrandsByBrandID(wineDTO.getBrand_id()));
        wine.setWineRegion(regionRepository.findByRegionID(wineDTO.getRegion_id()));
        wine.setWineGrape(grapeRepository.findByGrapeID(wineDTO.getGrape_id()));
        wine.setStrength(wineDTO.getAvg());
        wine.setProduction_year(wineDTO.getYear());
        wine.setWineColor(Color.valueOf(wineDTO.getColor()));
        wine.setWineSugar(Sugar.valueOf(wineDTO.getSugar()));
        wineRepository.save(wine);
    }

    @Override
    public WineDTO read(String id) {
        Wine wineByWineID = wineRepository.findWineByWineID(id);
        WineDTO wineDTO = new WineDTO();
        wineDTO.setId(wineByWineID.getWineID());
        wineDTO.setName(wineByWineID.getWineName());
        wineDTO.setProducer_id(wineByWineID.getWineProducer().getProducerID());
        wineDTO.setBrand_id(wineByWineID.getWineBrand().getBrandID());
        wineDTO.setRegion_id(wineByWineID.getWineRegion().getRegionID());
        wineDTO.setGrape_id(wineByWineID.getWineGrape().getGrapeID());
        wineDTO.setAvg(wineByWineID.getStrength());
        wineDTO.setYear(wineByWineID.getProduction_year());
        wineDTO.setColor(wineByWineID.getWineColor().name());
        wineDTO.setSugar(wineByWineID.getWineSugar().name());
        return wineDTO;
    }

    @Override
    public void update(String id, WineDTO wineDTO) {
        Wine wine = new Wine();
        wine.setWineID(id);
        wine.setWineName(wineDTO.getName());
        wine.setWineProducer(producerRepository.findByProducerID(wineDTO.getProducer_id()));
        wine.setWineBrand(brandRepository.findBrandsByBrandID(wineDTO.getBrand_id()));
        wine.setWineRegion(regionRepository.findByRegionID(wineDTO.getRegion_id()));
        wine.setWineGrape(grapeRepository.findByGrapeID(wineDTO.getGrape_id()));
        wine.setStrength(wineDTO.getAvg());
        wine.setProduction_year(wineDTO.getYear());
        wine.setWineColor(Color.valueOf(wineDTO.getColor()));
        wine.setWineSugar(Sugar.valueOf(wineDTO.getSugar()));
        wineRepository.save(wine);
    }

    @Override
    public void delete(String id) {
        wineRepository.deleteById(id);
    }
}
