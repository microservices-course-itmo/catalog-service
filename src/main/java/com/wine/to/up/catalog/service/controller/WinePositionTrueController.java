package com.wine.to.up.catalog.service.controller;

import com.google.common.primitives.Bytes;
import com.wine.to.up.catalog.service.domain.request.SettingsRequest;
import com.wine.to.up.catalog.service.domain.request.SortByRequest;
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
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
    @GetMapping("/byId/{id}")
    public WinePositionTrueResponse getWineById(@Valid @PathVariable(name = "id") String winePositionId) {
        WinePositionResponse wineById = winePositionController.getWineById(winePositionId);
        return getWinePositionTrueResponse(wineById);
    }

    @ApiOperation(value = "Get all wine positions",
            nickname = "getAllWinePositions", notes = "",
            tags = {"wine-position-true-controller",})
    @PostMapping("/")
    public List<WinePositionTrueResponse> getAllWinePositions(@RequestBody(required = false) SettingsRequest settingsRequest) {
        if (settingsRequest == null) {
            return winePositionController.getAllWinePositions()
                    .stream()
                    .map(this::getWinePositionTrueResponse)
                    .collect(Collectors.toList());
        }
        return winePositionController.getAllWinePositionsWithSettings(settingsRequest)
                .stream()
                .map(this::getWinePositionTrueResponse)
                .collect(Collectors.toList());
    }

    @ApiOperation(value = "Get all wine positions",
            nickname = "getAllWinePositions", notes = "",
            tags = {"wine-position-true-controller",})
    @GetMapping("/")
    public List<WinePositionTrueResponse> getAllWinePositions(
            @RequestParam(required = false) String from,
            @RequestParam(required = false) String to,
            @RequestParam(required = false) List<String> sortByPair,
            @RequestParam(required = false) String searchParameters
    ) {
        List<SortByRequest> collect = sortByPair
                .stream()
                .map(x -> {
                            String[] split = x.split("&");
                            SortByRequest sortByRequest = new SortByRequest();
                            sortByRequest.setAttribute(split[0]);
                            sortByRequest.setOrder(split[1]);
                            return sortByRequest;
                        }
                )
                .collect(Collectors.toList());
        SettingsRequest settingsRequest = new SettingsRequest();
        settingsRequest.setFrom((from == null || "".equals(from) )? 0: Integer.parseInt(from) );
        settingsRequest.setTo((to == null || "".equals(to) )? 0: Integer.parseInt(to) );
        settingsRequest.setSortBy(collect);
        settingsRequest.setSearchParameters(searchParameters);
        return getAllWinePositions(settingsRequest);
    }

    private WinePositionTrueResponse getWinePositionTrueResponse(WinePositionResponse wineById) {
        WinePositionTrueResponse winePositionTrueResponse = new WinePositionTrueResponse();

        winePositionTrueResponse.setWine_position_id(wineById.getWine_position_id());
        winePositionTrueResponse.setActual_price(wineById.getActual_price());
        winePositionTrueResponse.setDescription(wineById.getDescription());
        winePositionTrueResponse.setGastronomy(wineById.getGastronomy());
        winePositionTrueResponse.setImage(new String(Bytes.toArray(wineById.getImage())));
        winePositionTrueResponse.setLink_to_wine(wineById.getLink_to_wine());
        winePositionTrueResponse.setPrice(wineById.getPrice());
        winePositionTrueResponse.setShop(shopController.getShopById(wineById.getShop_id()));
        winePositionTrueResponse.setVolume(wineById.getVolume());
        winePositionTrueResponse.setWineTrueResponse(wineTrueController.getWineById(wineById.getWine_id()));
        return winePositionTrueResponse;
    }
}
