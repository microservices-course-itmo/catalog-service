package com.wine.to.up.catalog.service.controller;

import com.wine.to.up.catalog.service.domain.request.RegionRequest;
import com.wine.to.up.catalog.service.domain.response.RegionResponse;
import com.wine.to.up.catalog.service.mapper.controller2service.RegionControllerToRegionService;
import com.wine.to.up.catalog.service.service.RegionService;
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
@RequestMapping("/region")
@Validated
@Slf4j
@ApiIgnore
public class RegionController {
    private final RegionControllerToRegionService converter;
    private final RegionService regionService;

    @GetMapping("/{id}")
    public RegionResponse getRegionById(@Valid @PathVariable(name = "id") String regionId) {
        return converter.convert(regionService.read(regionId));
    }

    @GetMapping("/")
    public List<RegionResponse> getAllRegions() {
        return regionService.readAll()
                .stream()
                .map(converter::convert)
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public void updateRegion(@Valid @PathVariable(name = "id") String regionId,
                             @Valid @RequestBody RegionRequest regionRequest) {
        regionService.update(regionId, converter.convert(regionRequest));
    }

    @PostMapping("/")
    public void createRegion(@Valid @RequestBody RegionRequest regionRequest) {
        regionService.create(converter.convert(regionRequest));
    }
}
