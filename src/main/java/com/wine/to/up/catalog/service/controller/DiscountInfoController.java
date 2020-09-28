package com.wine.to.up.catalog.service.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
    public void createDiscountInfo(){

    }


    @ApiOperation(value = "Get discount info by id",
            nickname = "getDiscountInfoById", notes = "",
            tags={ "discount-info-controller", })
    @GetMapping("/{id}")
    public void getDiscountInfoById(){
    }


    @ApiOperation(value = "Update discount info by id",
            nickname = "updateDiscountInfoById", notes = "",
            tags={ "discount-info-controller", })
    @PutMapping("/{id}")
    public void updateDiscountInfoById(){

    }
}
