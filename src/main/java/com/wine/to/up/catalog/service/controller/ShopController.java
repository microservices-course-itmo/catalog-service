package com.wine.to.up.catalog.service.controller;


import com.wine.to.up.catalog.service.domain.request.ShopRequest;
import com.wine.to.up.catalog.service.domain.response.ShopResponse;
import com.wine.to.up.catalog.service.mapper.controller2service.ShopControllerToShopService;
import com.wine.to.up.catalog.service.service.ShopService;
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
@RequestMapping("/shop")
@Validated
@Slf4j
public class ShopController {
    private final ShopControllerToShopService converter;
    private final ShopService shopService;

    @GetMapping("/{id}")
    public ShopResponse getShopById(@Valid @PathVariable(name = "id") String shopId) {
        return converter.convert(shopService.read(shopId));
    }

    @GetMapping("/")
    public List<ShopResponse> getAllShops() {
        return shopService.readAll()
                .stream()
                .map(converter::convert)
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public void updateGrape(@Valid @PathVariable(name = "id") String shopId,
                            @Valid @RequestBody ShopRequest shopRequest) {
        shopService.update(shopId, converter.convert(shopRequest));
    }

    @PostMapping("/")
    public void createShop(@Valid @RequestBody ShopRequest shopRequest) {
        shopService.create(converter.convert(shopRequest));
    }
}
