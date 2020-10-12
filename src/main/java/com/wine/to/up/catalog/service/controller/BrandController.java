package com.wine.to.up.catalog.service.controller;


import com.wine.to.up.catalog.service.domain.request.BrandRequest;
import com.wine.to.up.catalog.service.domain.response.BrandResponse;
import com.wine.to.up.catalog.service.mapper.controller2service.BrandControllerToBrandService;
import com.wine.to.up.catalog.service.service.BrandService;
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
@RequestMapping("/brand")
@Validated
@Slf4j
@Api(value = "BrandController", description = "Brand controller")
public class BrandController {
    private final BrandControllerToBrandService converter;
    private final BrandService brandService;

    @ApiOperation(value = "Get brand position by id",
            nickname = "getBrandById", notes = "",
            tags = {"brand-controller",})
    @GetMapping("/{id}")
    public BrandResponse getBrandById(@Valid @PathVariable(name = "id") String brandId) {
        return converter.convert(brandService.read(brandId));
    }

    @ApiOperation(value = "Get all brand positions",
            nickname = "getAllBrands", notes = "",
            tags = {"brand-controller",})
    @GetMapping("/")
    public List<BrandResponse> getAllBrands() {
        return brandService.readAll().stream().map(converter::convert).collect(Collectors.toList());
    }

    @ApiOperation(value = "Update brand position by id",
            nickname = "getAllBrands", notes = "",
            tags = {"brand-controller",})
    @PutMapping("/{id}")
    public void updateBrand(@Valid @PathVariable(name = "id") String brandId,
                            @Valid @RequestBody BrandRequest brandRequest) {
        brandService.update(brandId, converter.convert(brandRequest));
    }

    @ApiOperation(value = "Create brand position",
            nickname = "createBrand", notes = "",
            tags = {"brand-controller",})
    @PostMapping("/")
    public void createBrand(@Valid @RequestBody BrandRequest brandRequest) {
        brandService.create(converter.convert(brandRequest));
    }
}
