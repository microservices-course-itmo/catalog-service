package com.wine.to.up.catalog.service.controller;


import com.wine.to.up.catalog.service.domain.response.WineResponse;
import com.wine.to.up.catalog.service.domain.response.WineTrueResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/wine/true")
@Validated
@Slf4j
@ApiIgnore
public class WineTrueController {

    private final WineController wineController;
    private final BrandController brandController;
    private final GrapeController grapeController;
    private final ProducerController producerController;
    private final RegionController regionController;

    @GetMapping("/")
    public List<WineTrueResponse> getAllWines() {
        return wineController.getAllWines().stream().map(this::getWineTrueResponse).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public WineTrueResponse getWineById(@Valid @PathVariable(name = "id") String wineId) {
        WineResponse wineById = wineController.getWineById(wineId);
        return getWineTrueResponse(wineById);
    }

    private WineTrueResponse getWineTrueResponse(WineResponse wineById) {
        WineTrueResponse wineTrueResponse = new WineTrueResponse();

        wineTrueResponse.setAvg(wineById.getAvg());
        wineTrueResponse.setYear(wineById.getYear());
        wineTrueResponse.setName(wineById.getName());
        wineTrueResponse.setSugar(wineById.getSugar());
        wineTrueResponse.setColor(wineById.getColor());
        wineTrueResponse.setBrandResponse(brandController.getBrandById(wineById.getBrand_id()));

        wineTrueResponse.setGrapeResponse(wineById.getGrape_id().stream().map(grapeController::getGrapeById).collect(Collectors.toList()));
        wineTrueResponse.setProducerResponse(producerController.getProducerById(wineById.getProducer_id()));

        wineTrueResponse.setRegionResponse(wineById.getRegion_id().stream().map(regionController::getRegionById).collect(Collectors.toList()));
        wineTrueResponse.setWine_id(wineById.getWine_id());
        return wineTrueResponse;
    }


}
