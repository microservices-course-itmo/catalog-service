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
public class BrandController {
    private final BrandControllerToBrandService converter;
    private final BrandService brandService;

    @GetMapping("/{id}")
    public BrandResponse getBrandById(@Valid @PathVariable(name = "id") String brandId) {
        return converter.convert(brandService.read(brandId));
    }

    @GetMapping("/")
    public List<BrandResponse> getAllBrands() {
        return brandService.readAll().stream().map(converter::convert).collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public void updateBrand(@Valid @PathVariable(name = "id") String brandId,
                            @Valid @RequestBody BrandRequest brandRequest) {
        brandService.update(brandId, converter.convert(brandRequest));
    }

    @PostMapping("/")
    public void createBrand(@Valid @RequestBody BrandRequest brandRequest) {
        brandService.create(converter.convert(brandRequest));
    }
}
