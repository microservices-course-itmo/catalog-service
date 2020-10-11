package com.wine.to.up.catalog.service.controller;


import com.wine.to.up.catalog.service.domain.request.BrandRequest;
import com.wine.to.up.catalog.service.domain.response.BrandResponse;
import com.wine.to.up.catalog.service.mapper.controller2service.BrandControllerToBrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/brand")
@Validated
@Slf4j
@Api(value = "BrandController", description = "Brand controller")
public class BrandController {
    private final BrandControllerToBrandService converter;

    @ApiOperation(value = "Get brand position by id",
            nickname = "getBrandById", notes = "",
            tags = {"brand-controller",})
    @GetMapping("/{id}")
    public BrandResponse getBrandById(@Valid @PathVariable(name = "id") String brandId) {
        return new BrandResponse();
    }

    @ApiOperation(value = "Get all brand positions",
            nickname = "getAllBrands", notes = "",
            tags = {"brand-controller",})
    @GetMapping("/")
    public void getAllGrapes() { ;
    }

    @ApiOperation(value = "Update brand position by id",
            nickname = "getAllBrands", notes = "",
            tags = {"brand-controller",})
    @PutMapping("/{id}")
    public void updateGrape(@Valid @PathVariable(name = "id") String brandId,
                            @Valid @RequestBody BrandRequest brandRequest) {
    }

    @ApiOperation(value = "Create brand position",
            nickname = "createBrand", notes = "",
            tags = {"brand-controller",})
    @PostMapping("/")
    public void createGrape(@Valid @RequestBody BrandRequest brandRequest) {
    }
}
