package com.wine.to.up.catalog.service.controller;

import com.wine.to.up.catalog.service.domain.request.SettingsRequest;
import com.wine.to.up.catalog.service.domain.request.WinePositionTrueRequest;
import com.wine.to.up.catalog.service.domain.response.WinePositionTrueResponse;
import com.wine.to.up.catalog.service.mapper.controller2service.WinePositionTrueControllerToWinePositionTrueService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/position/true")
@Validated
@Slf4j
//@Api(value = "WinePositionTrueController", description = "Wine position true controller")
public class WinePositionTrueController {
    private final WinePositionTrueControllerToWinePositionTrueService converter;

    @ApiOperation(value = "Get wine position by id",
            nickname = "getWinePositionById", notes = "",
            tags = {"wine-position-true-controller",})
    @GetMapping("/{id}")
    public WinePositionTrueResponse getWineById(@Valid @PathVariable(name = "id") String winePositionId) {
        return new WinePositionTrueResponse();
    }


    @ApiOperation(value = "Get all wine positions",
            nickname = "getAllWinePositions", notes = "",
            tags = {"wine-position-true-controller",})
    @GetMapping("/")
    public void getAllWinePositions(@RequestBody(required=false) SettingsRequest settingsRequest) {
    }

    @ApiOperation(value = "Create wine position",
            nickname = "createWinePosition", notes = "",
            tags = {"wine-position-true-controller",})
    @PostMapping("/")
    public void createWinePosition(@Valid @RequestBody WinePositionTrueRequest winePositionTrueRequest) {

    }

    @ApiOperation(value = "Update wine position",
            nickname = "updateWinePosition", notes = "",
            tags = {"wine-position-true-controller",})
    @PutMapping("/{id}")
    public void updateWinePosition(@Valid @PathVariable(name = "id") String winePositionId,
                                   @Valid @RequestBody WinePositionTrueRequest winePositionTrueRequest) {
    }

    @ApiOperation(value = "Delete wine position",
            nickname = "deleteWinePosition", notes = "",
            tags = {"wine-position-true-controller",})
    @DeleteMapping("/{id}")
    public void deleteWinePosition(@Valid @PathVariable(name = "id") String winePositionId) {
    }
}
