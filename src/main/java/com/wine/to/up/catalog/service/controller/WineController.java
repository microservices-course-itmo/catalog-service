package com.wine.to.up.catalog.service.controller;


import com.wine.to.up.catalog.service.domain.request.WinePositionRequest;
import com.wine.to.up.catalog.service.domain.response.WinePositionResponse;
import com.wine.to.up.catalog.service.mapper.controller2service.WineControllerToWineService;
import com.wine.to.up.catalog.service.service.WineManagerService;
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
@Api(value = "WineController", description = "Wine controller")
public class WineController {

    private final WineControllerToWineService converter;
    private final WineManagerService wineManagerService;

    @ApiOperation(value = "Get wine position by id",
            nickname = "getWinePositionById", notes = "",
            tags = {"wine-controller",})
    @GetMapping("/{id}")
    public WinePositionResponse getWinePositionById(@Valid @PathVariable(name = "id") String winePositionId) {
        return converter.convert(wineManagerService.getWinePositionById(winePositionId));
    }


    @ApiOperation(value = "Get all wine positions",
            nickname = "getAllWinePositions", notes = "",
            tags = {"wine-controller",})
    @GetMapping("/")
    public List<WinePositionResponse> getAllWinePositions() {
        return wineManagerService.getAllWinePositions().stream().map(converter::convert).collect(Collectors.toList());
    }

    @ApiOperation(value = "Create wine",
            nickname = "createWinePosition", notes = "",
            tags = {"wine-controller",})
    @PostMapping("/")
    public void createWinePosition(@Valid @RequestBody WinePositionRequest winePositionRequest) {
        wineManagerService.createWinePosition(converter.convert(winePositionRequest));
    }

    @ApiOperation(value = "Update wine position",
            nickname = "updateWinePosition", notes = "",
            tags = {"wine-controller",})
    @PutMapping("/{id}")
    public void updateWinePosition(@Valid @PathVariable(name = "id") String winePositionId,
                                   @Valid @RequestBody WinePositionRequest winePositionRequest) {
        wineManagerService.updateWinePosition(winePositionId,
                converter.convert(winePositionRequest));
    }

    @ApiOperation(value = "Delete wine position",
            nickname = "deleteWinePosition", notes = "",
            tags = {"wine-controller",})
    @DeleteMapping("/{id}")
    public void deleteWinePosition(@Valid @PathVariable(name = "id") String winePositionId) {
        wineManagerService.deleteWinePosition(winePositionId);
    }
}
