package com.wine.to.up.catalog.service.service;

import com.wine.to.up.catalog.service.domain.dto.WineDTO;
import com.wine.to.up.catalog.service.domain.entities.*;
import com.wine.to.up.catalog.service.domain.enums.Color;
import com.wine.to.up.catalog.service.domain.enums.Sugar;
import com.wine.to.up.catalog.service.mapper.service2repository.WineServiceToWineRepository;
import com.wine.to.up.catalog.service.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class WineManagerService {

    private final WineServiceToWineRepository converter;
    private final WineRepository wineRepository;
    private final BrandRepository brandRepository;
    private final CountryRepository countryRepository;
    private final GrapeInfoRepository grapeInfoRepository;
    private final PositionPriceRepository positionPriceRepository;


    public WineDTO getWinePositionById(String id) {
        WineDTO convert = converter.convert(wineRepository.findWineBywineID(id));
        convert.setGrapes_info(wineRepository.findWineBywineID(id).getWineGrapesInfos()
                .stream()
                .map(WineGrapesInfo::getGrapeID)
                .collect(Collectors.toList()
                )
        );
        return convert;
    }

    public List<WineDTO> getAllWinePositions() {
        return StreamSupport
                .stream(wineRepository.findAll().spliterator(), false)
                .map((Wine wine) -> {
                    return getWinePositionById(wine.getWineID());
                })
                .collect(Collectors.toList());

    }

    public void createWinePosition(WineDTO wineDTO) {
        wineDTO.setId(UUID.randomUUID().toString());

        Wine result = getWineFromDTO(wineDTO);
        wineRepository.save(result);
        updateGrapesInfo(wineDTO, result);
    }

    private void updateGrapesInfo(WineDTO wineDTO, Wine result) {
        result.setWineGrapesInfos(wineDTO.getGrapes_info().stream()
                .map((String value) -> {
                    WineGrapesInfo wineGrapesInfo = new WineGrapesInfo();
                    wineGrapesInfo.setWineID(wineDTO.getId());
                    wineGrapesInfo.setGrapeID(value);
                    grapeInfoRepository.save(wineGrapesInfo);
                    return wineGrapesInfo;
                })
                .collect(Collectors.toList())
        );
    }

    private Wine getWineFromDTO(WineDTO wineDTO) {
        Wine result = converter.convert(wineDTO);

        try {
            result.setSugar(Sugar.valueOf(wineDTO.getSugar_content()));
        } catch (Exception e) {
            System.out.println("oups");
            result.setSugar(Sugar.DRY);
        }
        try {
            result.setColor(Color.valueOf(wineDTO.getColor()));
        } catch (Exception e) {
            System.out.println("oups");
            result.setColor(Color.ROSE);
        }

        List<Country> countryByCountryName = countryRepository.findCountryByCountryName(wineDTO.getProduction_country());
        if (countryByCountryName != null && !countryByCountryName.isEmpty()) {
            result.setCountry(countryByCountryName.get(0));
        } else {
            Country country = new Country();
            country.setCountryName(wineDTO.getProduction_country());
            countryRepository.save(country);
            result.setCountry(country);
        }

        List<Brand> brandByBrandName = brandRepository.findBrandByBrandName(wineDTO.getBrand());
        if (brandByBrandName != null && !brandByBrandName.isEmpty()) {
            result.setBrand(brandByBrandName.get(0));
        } else {
            Brand brand = new Brand();
            brand.setBrandName(wineDTO.getBrand());
            brandRepository.save(brand);
            result.setBrand(brand);
        }
        return result;
    }

    public void updateWinePosition(String id, WineDTO wineDTO) {
        wineDTO.setId(id);
        Wine result = getWineFromDTO(wineDTO);
        wineRepository.save(result);
        updateGrapesInfo(wineDTO, result);
    }

    public void deleteWinePosition(String id) {
        Wine wineBywineID = wineRepository.findWineBywineID(id);
        wineRepository.delete(wineBywineID);
    }

}
