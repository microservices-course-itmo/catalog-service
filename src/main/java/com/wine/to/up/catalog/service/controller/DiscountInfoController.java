package com.wine.to.up.catalog.service.controller;


import com.wine.to.up.catalog.service.domain.request.DiscountInfoRequest;
import com.wine.to.up.catalog.service.domain.response.DiscountInfoResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/discountinfo")
@Validated
@Slf4j
@Api(value = "DiscountInfoController", description = "Discount info controller")
public class DiscountInfoController {


    @ApiOperation(value = "Create discount info",
            nickname = "createDiscountInfo", notes = "",
            tags={ "discount-info-controller", })
    @PostMapping("/")
    public void createDiscountInfo(@Valid @RequestBody DiscountInfoRequest discountInfoRequest){

    }


    @ApiOperation(value = "Get discount info by id",
            nickname = "getDiscountInfoById", notes = "",
            tags={ "discount-info-controller", })
    @GetMapping("/{id}")
    public DiscountInfoResponse getDiscountInfoById(@Valid @PathVariable(name = "id") Integer discountInfoId){
        return null;
    }


    @ApiOperation(value = "Update discount info by id",
            nickname = "updateDiscountInfoById", notes = "",
            tags={ "discount-info-controller", })
    @PutMapping("/{id}")
    public void updateDiscountInfoById(@Valid @PathVariable(name = "id") Integer discountInfoId,
                                       @Valid @RequestBody DiscountInfoRequest discountInfoRequest){

    }

    @ApiOperation(value = "Delete discount info",
            nickname = "deleteDiscountInfo", notes = "",
            tags={ "discount-info-controller", })
    @DeleteMapping("/{id}")
    public void deleteWinePosition(@Valid @PathVariable(name = "id") Integer discountInfoId){

    }
}
