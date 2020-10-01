package com.wine.to.up.catalog.service.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/position")
@Validated
@Slf4j
@Api(value = "WineController", description = "Wine controller")
public class WineController {

    @ApiOperation(value = "Get wine position by id",
            nickname = "getWinePositionById", notes = "",
            tags={ "wine-controller", })
    @GetMapping("/{id}")
    public void getWinePositionById(){
    }


    @ApiOperation(value = "Get all wine positions",
            nickname = "getAllWinePostions", notes = "",
            tags={ "wine-controller", })
    @GetMapping("/")
    public void getAllWinePostions(){
    }

    @ApiOperation(value = "Create wine",
            nickname = "createWinePosition", notes = "",
            tags={ "wine-controller", })
    @PostMapping("/")
    public void createWinePosition(){

    }

    @ApiOperation(value = "Update wine position",
            nickname = "updateWinePosition", notes = "",
            tags={ "wine-controller", })
    @PutMapping("/{id}")
    public void updateWinePosition(){

    }
}
