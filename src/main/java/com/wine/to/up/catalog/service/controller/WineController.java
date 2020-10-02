package com.wine.to.up.catalog.service.controller;


import com.wine.to.up.catalog.service.domain.entities.Wine;
import com.wine.to.up.catalog.service.domain.req.WineRequest;
import com.wine.to.up.catalog.service.domain.res.DiscountInfoResponse;
import com.wine.to.up.catalog.service.domain.res.WineResponse;
import com.wine.to.up.catalog.service.service.WineManagerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/position")
@Validated
@Slf4j
@Api(value = "WineController", description = "Wine controller")
public class WineController {

    private final WineManagerService wineManagerService;

    @ApiOperation(value = "Get wine position by id",
            nickname = "getWinePositionById", notes = "",
            tags={ "wine-controller"},
            response = WineResponse.class)
    @ApiResponses(value = {
            @ApiResponse(
                    code = 200,
                    message = "Wine found",
                    response = WineResponse.class
            )
    })
    @GetMapping("/{id}")
    public WineResponse getWinePositionById(@PathVariable String id){
        wineManagerService.getWinePositionById(id);
        return new WineResponse();
    }


    @ApiOperation(value = "Get all wine positions",
            nickname = "getAllWinePostions", notes = "",
            tags={ "wine-controller", })
    @ApiResponses(value = {
            @ApiResponse(
                    code = 200,
                    message = "Wines found",
                    response = WineResponse.class,
                    responseContainer = "List"
            )
    })
    @GetMapping("/")
    public List<Wine> getAllWinePositions(){
        return wineManagerService.getAllWinePositions();
    }

    @ApiOperation(value = "Create wine",
            nickname = "createWinePosition", notes = "",
            tags={ "wine-controller", })
    @ApiResponses(value = {
            @ApiResponse(
                    code = 200,
                    message = "Wine created"
            )
    })
    @PostMapping("/")
    public void createWinePosition(@RequestBody WineRequest wineRequest){
        wineManagerService.createWinePosition(new Wine());
    }

    @ApiOperation(value = "Update wine position",
            nickname = "updateWinePosition", notes = "",
            tags={ "wine-controller", })
    @ApiResponses(value = {
            @ApiResponse(
                    code = 200,
                    message = "Wine updated"
            )
    })
    @PutMapping("/{id}")
    public void updateWinePosition(@PathVariable String id, @RequestBody @NotNull WineRequest wineRequest){
        Wine wine = new Wine();
        wineManagerService.updateWinePosition(id, wine);
    }
}
