package com.wine.to.up.catalog.service.controller;

import com.wine.to.up.catalog.service.domain.entities.WinePosition;
import com.wine.to.up.catalog.service.domain.request.SettingsRequest;
import com.wine.to.up.catalog.service.domain.request.WinePositionRequest;
import com.wine.to.up.catalog.service.domain.response.WinePositionResponse;
import com.wine.to.up.catalog.service.mapper.controller2service.WinePositionControllerToWinePositionService;
import com.wine.to.up.catalog.service.service.WinePositionService;
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
@RequestMapping("/position")
@Validated
@Slf4j
@Api(value = "WinePositionController", description = "Wine position controller")
public class WinePositionController {
    private final WinePositionControllerToWinePositionService converter;
    private final WinePositionService winePositionService;

    @ApiOperation(value = "Get wine position by id",
            nickname = "getWinePositionById", notes = "",
            tags = {"wine-position-controller",})
    @GetMapping("/{id}")
    public WinePositionResponse getWineById(@Valid @PathVariable(name = "id") String winePositionId) {
        return converter.convert(winePositionService.read(winePositionId));
    }


    @ApiOperation(value = "Get all wine positions within a price range",
            nickname = "getAllWinePositionsWithinPriceRange", notes = "",
            tags = {"wine-position-controller",})
    @GetMapping("/{lower_price_bound}/{upper_price_bound}")
    public List<WinePositionResponse> getAllWinePositionsWithinPriceRange(@Valid @PathVariable(name = "lower_price_bound") String lowerPriceBound,
                                                                  @Valid @PathVariable(name = "upper_price_bound") String upperPriceBound){
        return winePositionService.readAllWinePositionsWithinPriceRange(lowerPriceBound, upperPriceBound)
                .stream()
                .map(converter::convert)
                .collect(Collectors.toList());
    }


    @ApiOperation(value = "Get all wine positions",
            nickname = "getAllWinePositions", notes = "",
            tags = {"wine-position-controller",})
    @GetMapping("/")
    public List<WinePositionResponse> getAllWinePositions() {
        return winePositionService.readAll()
                .stream()
                .map(converter::convert)
                .collect(Collectors.toList());
    }

    @ApiOperation(value = "Get all wine positions",
            nickname = "getAllWinePositions", notes = "",
            tags = {"wine-position-controller",})
    @PostMapping("/getAllWithSettings")
    public List<WinePositionResponse> getAllWinePositionsWithSettingsg(@RequestBody(required = false) SettingsRequest settingsRequest) {
        return winePositionService.readAllWithSettings(settingsRequest)
                .stream()
                .map(converter::convert)
                .collect(Collectors.toList());
    }

    @ApiOperation(value = "Create wine position",
            nickname = "createWinePosition", notes = "",
            tags = {"wine-position-controller",})
    @PostMapping("/")
    public void createWinePosition(@Valid @RequestBody WinePositionRequest winePositionRequest) {
        winePositionService.create(converter.convert(winePositionRequest));
    }

    @ApiOperation(value = "Update wine position",
            nickname = "updateWinePosition", notes = "",
            tags = {"wine-position-controller",})
    @PutMapping("/{id}")
    public void updateWinePosition(@Valid @PathVariable(name = "id") String winePositionId,
                                   @Valid @RequestBody WinePositionRequest winePositionRequest) {
        winePositionService.update(winePositionId, converter.convert(winePositionRequest));
    }

    @ApiOperation(value = "Delete wine position",
            nickname = "deleteWinePosition", notes = "",
            tags = {"wine-position-controller",})
    @DeleteMapping("/{id}")
    public void deleteWinePosition(@Valid @PathVariable(name = "id") String winePositionId) {
        winePositionService.delete(winePositionId);
    }
}
