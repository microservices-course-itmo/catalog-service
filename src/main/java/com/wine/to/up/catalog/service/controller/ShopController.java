package com.wine.to.up.catalog.service.controller;


import com.wine.to.up.catalog.service.domain.request.ShopRequest;
import com.wine.to.up.catalog.service.domain.response.ShopResponse;
import com.wine.to.up.catalog.service.mapper.controller2service.ShopControllerToShopService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/shop")
@Validated
@Slf4j
@Api(value = "ShopController", description = "Shop controller")
public class ShopController {
    private final ShopControllerToShopService converter;

    @ApiOperation(value = "Get shop by id",
            nickname = "getShopById", notes = "",
            tags = {"shop-controller",})
    @GetMapping("/{id}")
    public ShopResponse getShopById(@Valid @PathVariable(name = "id") String shopId) {
        return new ShopResponse();
    }


    @ApiOperation(value = "Get all shops",
            nickname = "getAllShops", notes = "",
            tags = {"shop-controller",})
    @GetMapping("/")
    public void getAllShops() {
    }

    @ApiOperation(value = "Update shop by id",
            nickname = "updateShop", notes = "",
            tags = {"shop-controller",})
    @PutMapping("/{id}")
    public void updateGrape(@Valid @PathVariable(name = "id") String shopId,
                            @Valid @RequestBody ShopRequest shopRequest) {
    }

    @ApiOperation(value = "Create shop",
            nickname = "createShop", notes = "",
            tags = {"shop-controller",})
    @PostMapping("/")
    public void createShop(@Valid @RequestBody ShopRequest shopRequest) {
    }
}
