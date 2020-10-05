package com.wine.to.up.catalog.service.controller;


import com.wine.to.up.catalog.service.domain.request.GrapeRequest;
import com.wine.to.up.catalog.service.domain.request.WinePositionRequest;
import com.wine.to.up.catalog.service.domain.response.GrapeResponse;
import com.wine.to.up.catalog.service.repository.GrapeRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
    public GrapeResponse getGrapeById(@Valid @PathVariable(name = "id") Integer grapeId){
        return null;
    }


    @ApiOperation(value = "Get all grape positions",
            nickname = "getAllGrapes", notes = "",
            tags={ "grape-controller", })
    @GetMapping("/")
    public List<GrapeResponse> getAllGrapes(){
        return null;
    }

    @ApiOperation(value = "Update grape position by id",
            nickname = "getAllGrapes", notes = "",
            tags={ "grape-controller", })
    @PutMapping("/{id}")
    public void updateGrape(@Valid @PathVariable(name = "id") Integer grapeId,
                            @Valid @RequestBody GrapeRequest grapeRequest){

    }

    @ApiOperation(value = "Create grape position",
            nickname = "createGrape", notes = "",
            tags={ "grape-controller", })
    @PostMapping("/")
    public void createGrape(@Valid @RequestBody GrapeRequest grapeRequest){

    }

}
