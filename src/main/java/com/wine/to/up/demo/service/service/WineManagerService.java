package com.wine.to.up.demo.service.service;

import com.wine.to.up.demo.service.domain.entities.Brand;
import com.wine.to.up.demo.service.domain.entities.Wine;
import com.wine.to.up.demo.service.repository.BrandRepository;
import com.wine.to.up.demo.service.repository.WineRepository;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WineManagerService {

    private final WineRepository wineRepository;
    private final BrandRepository brandRepository;

    public Wine getWinePositionById(String id) {
        int intId = Integer.parseInt(id);
        return wineRepository.findWineBywineID(intId);
    }

    public List<Wine> getAllWinePositions() {
        Iterable<Wine> source = wineRepository.findAll();
        List<Wine> target = new ArrayList<>();
        source.forEach(target::add);
        return target;
    }

    //Change argument to WineDto and create dto
    public Wine createWinePosition(Wine wine) {
        Brand brandByBrandName = brandRepository.findBrandByBrandName(wine.getBrand().getBrandName());
        if (brandByBrandName == null) {
            brandRepository.save(wine.getBrand());
        }
        wine.setBrand(brandByBrandName);
        wineRepository.save(wine);
        return wine;
    }

    //Change argument to WineDto and create dto
    public Wine updateWinePosition(String id, Wine wine) {
        wine.setWineID(Integer.parseInt(id));
        wineRepository.save(wine);
        return wine;
    }
}
