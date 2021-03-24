package com.wine.to.up.catalog.service.controller;

import com.wine.to.up.catalog.service.domain.entities.WinePosition;
import com.wine.to.up.catalog.service.domain.request.SettingsRequest;
import com.wine.to.up.catalog.service.domain.request.SettingsTrueRequest;
import com.wine.to.up.catalog.service.domain.request.WinePositionRequest;
import com.wine.to.up.catalog.service.domain.response.WinePositionResponse;
import com.wine.to.up.catalog.service.mapper.controller2service.WinePositionControllerToWinePositionService;
import com.wine.to.up.catalog.service.service.WinePositionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
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
public class WinePositionController {
    private final WinePositionControllerToWinePositionService converter;
    private final WinePositionService winePositionService;

    @GetMapping("/{id}")
    public WinePositionResponse getWineById(@Valid @PathVariable(name = "id") String winePositionId) {
        return converter.convert(winePositionService.read(winePositionId));
    }

    @GetMapping("/")
    public List<WinePositionResponse> getAllWinePositions() {
        return winePositionService.readAll()
                .stream()
                .map(converter::convert)
                .collect(Collectors.toList());
    }

    @PostMapping("/getAllWithSettings")
    public List<WinePositionResponse> getAllWinePositionsWithSettings(@RequestBody(required = false) SettingsRequest settingsRequest){
        return winePositionService.readAllWithSettings(settingsRequest)
                .stream()
                .map(converter::convert)
                .collect(Collectors.toList());
    }

    @PostMapping("/")
    public void createWinePosition(@Valid @RequestBody WinePositionRequest winePositionRequest) {
        winePositionService.create(converter.convert(winePositionRequest));
    }

    @PutMapping("/{id}")
    public void updateWinePosition(@Valid @PathVariable(name = "id") String winePositionId,
                                   @Valid @RequestBody WinePositionRequest winePositionRequest) {
        winePositionService.update(winePositionId, converter.convert(winePositionRequest));
    }

    @DeleteMapping("/{id}")
    public void deleteWinePosition(@Valid @PathVariable(name = "id") String winePositionId) {
        winePositionService.delete(winePositionId);
    }
}
