package com.wine.to.up.catalog.service.controller;


import com.wine.to.up.catalog.service.domain.res.DiscountInfoResponse;
import com.wine.to.up.catalog.service.service.DiscountInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/discountinfo")
@Validated
@Slf4j
@Api(value = "DiscountInfoController", description = "Discount info controller")
public class DiscountInfoController {
    @Autowired
    DiscountInfoService discountInfoService;

    @ApiOperation(value = "Create discount info",
            nickname = "createDiscountInfo", notes = "",
            tags={ "discount-info-controller"})
    @ApiResponses(value = {
            @ApiResponse(
                    code = 200,
                    message = "Discount created"
            )
    })
    @PostMapping("/")
    public void createDiscountInfo(){

    }


    @ApiOperation(value = "Get discount info by id",
            nickname = "getDiscountInfoById", notes = "",
            tags={ "discount-info-controller"},
            response = DiscountInfoResponse.class)
    @ApiResponses(value = {
            @ApiResponse(
                    code = 200,
                    message = "Discount found",
                    response = DiscountInfoResponse.class
            )
    })
    @GetMapping("/{id}")
    public DiscountInfoResponse getDiscountInfoById(@PathVariable String id){
        return new DiscountInfoResponse();
    }


    @ApiOperation(value = "Update discount info by id",
            nickname = "updateDiscountInfoById", notes = "",
            tags={ "discount-info-controller", })
    @ApiResponses(value = {
            @ApiResponse(
                    code = 200,
                    message = "Discount updated"
            )
    })
    @PutMapping("/{id}")
    public void updateDiscountInfoById(@PathVariable String id, @RequestBody DiscountInfoResponse discountInfoResponse){

    }
}
