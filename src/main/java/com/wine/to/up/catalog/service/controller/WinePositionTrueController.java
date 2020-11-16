package com.wine.to.up.catalog.service.controller;

import com.wine.to.up.catalog.service.domain.request.SettingsRequest;
import com.wine.to.up.catalog.service.domain.response.WinePositionResponse;
import com.wine.to.up.catalog.service.domain.response.WinePositionTrueResponse;
import com.wine.to.up.catalog.service.utils.CompareChain;
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
@RequestMapping("/position/true")
@Validated
@Slf4j
@Api(value = "WinePositionTrueController", description = "Wine position true controller")
public class WinePositionTrueController {
    private final WinePositionController winePositionController;
    private final ShopController shopController;
    private final WineTrueController wineTrueController;

    @ApiOperation(value = "Get wine position by id",
            nickname = "getWinePositionById", notes = "",
            tags = {"wine-position-true-controller",})
    @GetMapping("/{id}")
    public WinePositionTrueResponse getWineById(@Valid @PathVariable(name = "id") String winePositionId) {
        WinePositionResponse wineById = winePositionController.getWineById(winePositionId);
        return getWinePositionTrueResponse(wineById);
    }

    @ApiOperation(value = "Get all wine positions",
            nickname = "getAllWinePositions", notes = "",
            tags = {"wine-position-true-controller",})
    @PostMapping("/")
    public List<WinePositionTrueResponse> getAllWinePositions(@RequestBody(required = false) SettingsRequest settingsRequest) {
        CompareChain processedChain = new CompareChain().process(settingsRequest.getSearchParameters(), settingsRequest.getSortBy());
        return winePositionController.getAllWinePositions()
                .stream()
                .map(this::getWinePositionTrueResponse)
                .filter(processedChain)
                .sorted(processedChain)
                .skip(settingsRequest.getFrom())
                .limit(settingsRequest.getTo() - settingsRequest.getFrom())
                .collect(Collectors.toList());
    }

    private WinePositionTrueResponse getWinePositionTrueResponse(WinePositionResponse wineById) {
        WinePositionTrueResponse winePositionTrueResponse = new WinePositionTrueResponse();

        winePositionTrueResponse.setWine_position_id(wineById.getWine_position_id());
        winePositionTrueResponse.setActual_price(wineById.getActual_price());
        winePositionTrueResponse.setDescription(wineById.getDescription());
        winePositionTrueResponse.setGastronomy(wineById.getGastronomy());
        winePositionTrueResponse.setImage(wineById.getImage());
        winePositionTrueResponse.setLink_to_wine(wineById.getLink_to_wine());
        winePositionTrueResponse.setPrice(wineById.getPrice());
        winePositionTrueResponse.setShop(shopController.getShopById(wineById.getShop_id()));
        winePositionTrueResponse.setVolume(wineById.getVolume());
        winePositionTrueResponse.setWineTrueResponse(wineTrueController.getWineById(wineById.getWine_id()));
        return winePositionTrueResponse;
    }
}
