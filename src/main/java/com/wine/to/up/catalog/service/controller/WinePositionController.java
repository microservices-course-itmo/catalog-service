package com.wine.to.up.catalog.service.controller;

import com.wine.to.up.catalog.service.domain.request.SettingsRequest;
import com.wine.to.up.catalog.service.domain.request.WinePositionRequest;
import com.wine.to.up.catalog.service.domain.response.WinePositionResponse;
import com.wine.to.up.catalog.service.mapper.controller2service.WinePositionControllerToWinePositionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/position")
@Validated
@Slf4j
@Api(value = "WinePositionController", description = "Wine position controller")
public class WinePositionController {
    private final WinePositionControllerToWinePositionService converter;

    @ApiOperation(value = "Get wine position by id",
            nickname = "getWinePositionById", notes = "",
            tags = {"wine-position-controller",})
    @GetMapping("/{id}")
    public WinePositionResponse getWineById(@Valid @PathVariable(name = "id") String winePositionId) {
        return new WinePositionResponse();
    }


    @ApiOperation(value = "Get all wine positions",
            nickname = "getAllWinePositions", notes = "",
            tags = {"wine-position-controller",})
    @GetMapping("/")
    public void getAllWinePositions(@RequestBody(required=false) SettingsRequest settingsRequest) {
    }

    @ApiOperation(value = "Create wine position",
            nickname = "createWinePosition", notes = "",
            tags = {"wine-position-controller",})
    @PostMapping("/")
    public void createWinePosition(@Valid @RequestBody WinePositionRequest winePositionRequest) {

    }

    @ApiOperation(value = "Update wine position",
            nickname = "updateWinePosition", notes = "",
            tags = {"wine-position-controller",})
    @PutMapping("/{id}")
    public void updateWinePosition(@Valid @PathVariable(name = "id") String winePositionId,
                                   @Valid @RequestBody WinePositionRequest winePositionRequest) {
    }

    @ApiOperation(value = "Delete wine position",
            nickname = "deleteWinePosition", notes = "",
            tags = {"wine-position-controller",})
    @DeleteMapping("/{id}")
    public void deleteWinePosition(@Valid @PathVariable(name = "id") String winePositionId) {
    }
}
