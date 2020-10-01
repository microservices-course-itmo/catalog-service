package com.wine.to.up.catalog.service.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/grape")
@Validated
@Slf4j
@Api(value = "WineController", description = "Grape controller")
public class GrapeController {

    @ApiOperation(value = "Get grape position by id",
            nickname = "getGrapeById", notes = "",
            tags={ "grape-controller", })
    @GetMapping("/{id}")
    public void getGrapeById(){
    }


    @ApiOperation(value = "Get all grape positions",
            nickname = "getAllGrapes", notes = "",
            tags={ "grape-controller", })
    @GetMapping("/")
    public void getAllGrapes(){
    }

    @ApiOperation(value = "Update grape position by id",
            nickname = "getAllGrapes", notes = "",
            tags={ "grape-controller", })
    @PutMapping("/{id}")
    public void updateGrape(){

    }

    @ApiOperation(value = "Create grape position",
            nickname = "createGrape", notes = "",
            tags={ "grape-controller", })
    @PostMapping("/")
    public void createGrape(){

    }
}
