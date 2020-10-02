package com.wine.to.up.catalog.service.controller;


import com.wine.to.up.catalog.service.domain.res.DiscountInfoResponse;
import com.wine.to.up.catalog.service.domain.res.GrapeResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
            tags={ "grape-controller"},
            response = GrapeResponse.class)
    @ApiResponses(value = {
            @ApiResponse(
                    code = 200,
                    message = "Grape found",
                    response = GrapeResponse.class
            )
    })
    @GetMapping("/{id}")
    public GrapeResponse getGrapeById(@PathVariable String id){
        return new GrapeResponse();
    }


    @ApiOperation(value = "Get all grape positions",
            nickname = "getAllGrapes", notes = "",
            tags={ "grape-controller", })
    @ApiResponses(value = {
            @ApiResponse(
                    code = 200,
                    message = "Grapes found",
                    response = GrapeResponse.class,
                    responseContainer = "List"
            )
    })
    @GetMapping("/")
    public void getAllGrapes(){
    }

    @ApiOperation(value = "Update grape position by id",
            nickname = "getAllGrapes", notes = "",
            tags={ "grape-controller", })
    @ApiResponses(value = {
            @ApiResponse(
                    code = 200,
                    message = "Grape updated"
            )
    })
    @PutMapping("/{id}")
    public void updateGrape(@PathVariable String id, @RequestBody GrapeResponse grapeResponse){

    }

    @ApiOperation(value = "Create grape position",
            nickname = "createGrape", notes = "",
            tags={ "grape-controller", })
    @ApiResponses(value = {
            @ApiResponse(
                    code = 200,
                    message = "Wine created"
            )
    })
    @PostMapping("/")
    public void createGrape(@RequestBody GrapeResponse grapeResponse){

    }
}
