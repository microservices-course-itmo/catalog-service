package com.wine.to.up.catalog.service.controller;

import com.wine.to.up.catalog.service.domain.request.RegionRequest;
import com.wine.to.up.catalog.service.domain.response.RegionResponse;
import com.wine.to.up.catalog.service.mapper.controller2service.RegionControllerToRegionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/region")
@Validated
@Slf4j
@Api(value = "RegionController", description = "Region controller")
public class RegionController {
    private final RegionControllerToRegionService converter;

    @ApiOperation(value = "Get region by id",
            nickname = "getRegionById", notes = "",
            tags = {"region-controller",})
    @GetMapping("/{id}")
    public RegionResponse getRegionById(@Valid @PathVariable(name = "id") String regionId) {
        return new RegionResponse();
    }

    @ApiOperation(value = "Get all regions positions",
            nickname = "getAllRegions", notes = "",
            tags = {"region-controller",})
    @GetMapping("/")
    public void getAllRegions() { ;
    }

    @ApiOperation(value = "Update region by id",
            nickname = "updateRegion", notes = "",
            tags = {"region-controller",})
    @PutMapping("/{id}")
    public void updateRegion(@Valid @PathVariable(name = "id") String regionId,
                             @Valid @RequestBody RegionRequest regionRequest) {
    }

    @ApiOperation(value = "Create region position",
            nickname = "createRegion", notes = "",
            tags = {"region-controller",})
    @PostMapping("/")
    public void createRegion(@Valid @RequestBody RegionRequest regionRequest) {
    }
}
