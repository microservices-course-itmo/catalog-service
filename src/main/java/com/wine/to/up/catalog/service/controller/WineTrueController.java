package com.wine.to.up.catalog.service.controller;


import com.wine.to.up.catalog.service.domain.request.WineTrueRequest;
import com.wine.to.up.catalog.service.domain.response.WineTrueResponse;
import com.wine.to.up.catalog.service.mapper.controller2service.WineTrueControllerToWineTrueService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/wine/true")
@Validated
@Slf4j
@Api(value = "WineTrueController", description = "Wine true controller")
public class WineTrueController {
    private final WineTrueControllerToWineTrueService converter;

    @ApiOperation(value = "Get wine by id",
            nickname = "getWineById", notes = "",
            tags = {"wine-controller",})
    @GetMapping("/{id}")
    public WineTrueResponse getWineById(@Valid @PathVariable(name = "id") String wineId) {
        return new WineTrueResponse();
    }


    @ApiOperation(value = "Get all wine",
            nickname = "getAllWines", notes = "",
            tags = {"wine-controller",})
    @GetMapping("/")
    public void getAllWines() {
    }

    @ApiOperation(value = "Create wine",
            nickname = "createWine", notes = "",
            tags = {"wine-controller",})
    @PostMapping("/")
    public void createWine(@Valid @RequestBody WineTrueRequest wineTrueRequest) {

    }

    @ApiOperation(value = "Update wine",
            nickname = "updateWine", notes = "",
            tags = {"wine-controller",})
    @PutMapping("/{id}")
    public void updateWine(@Valid @PathVariable(name = "id") String wineId,
                           @Valid @RequestBody WineTrueRequest wineTrueRequest) {
    }

    @ApiOperation(value = "Delete wine",
            nickname = "deleteWine", notes = "",
            tags = {"wine-controller",})
    @DeleteMapping("/{id}")
    public void deleteWine(@Valid @PathVariable(name = "id") String wineId) {
    }
}
