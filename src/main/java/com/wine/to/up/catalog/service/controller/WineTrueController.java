package com.wine.to.up.catalog.service.controller;


import com.wine.to.up.catalog.service.domain.response.WineResponse;
import com.wine.to.up.catalog.service.domain.response.WineTrueResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/wine/true")
@Validated
@Slf4j
@Api(value = "WineTrueController", description = "Wine true controller")
public class WineTrueController {

    private final WineController wineController;
    private final BrandController brandController;
    private final GrapeController grapeController;
    private final ProducerController producerController;
    private final RegionController regionController;

    @ApiOperation(value = "Get all wine",
            nickname = "getAllWines", notes = "",
            tags = {"wine-true-controller",})
    @GetMapping("/")
    public List<WineTrueResponse> getAllWines() {
        return wineController.getAllWines().stream().map(this::getWineTrueResponse).collect(Collectors.toList());
    }

    @ApiOperation(value = "Get wine by id",
            nickname = "getWineById", notes = "",
            tags = {"wine-true-controller",})
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
        wineTrueResponse.setGrapeResponse(grapeController.getGrapeById(wineById.getGrape_id()));
        wineTrueResponse.setProducerResponse(producerController.getProducerById(wineById.getProducer_id()));
        wineTrueResponse.setRegionResponse(regionController.getRegionById(wineById.getRegion_id()));
        wineTrueResponse.setWine_id(wineById.getWine_id());
        return wineTrueResponse;
    }


}
