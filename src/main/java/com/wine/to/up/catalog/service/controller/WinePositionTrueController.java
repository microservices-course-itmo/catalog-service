package com.wine.to.up.catalog.service.controller;

import com.google.common.primitives.Bytes;
import com.wine.to.up.catalog.service.domain.request.SettingsRequest;
import com.wine.to.up.catalog.service.domain.request.SortByRequest;
import com.wine.to.up.catalog.service.domain.response.RegionResponse;
import com.wine.to.up.catalog.service.domain.response.WinePositionResponse;
import com.wine.to.up.catalog.service.domain.response.WinePositionTrueResponse;
import com.wine.to.up.catalog.service.domain.response.WineTrueResponse;
import com.wine.to.up.catalog.service.utils.CompareChain;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

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

    @ApiOperation(value = "Get favourites wine positions",
            nickname = "getFavouritesPositions",
            tags = {"wine-position-true-controller",})
    @GetMapping("/favourites")
    public List<WinePositionTrueResponse> getFavourites(@Valid @RequestParam(required = true) List<String> favouritePosition) {
        return favouritePosition.stream().map(this::getWineById).collect(Collectors.toList());
    }

    @ApiIgnore
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

    @ApiIgnore
    @GetMapping("/")
    public List<WinePositionTrueResponse> getAllWinePositions(
            @RequestParam(required = false) String from,
            @RequestParam(required = false) String to,
            @RequestParam(required = false) List<String> sortByPair,
            @RequestParam(required = false) String searchParameters
    ) {
        SettingsRequest settingsRequest = new SettingsRequest();
        if (sortByPair != null) {
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
            settingsRequest.setSortBy(collect);
        }
        settingsRequest.setFrom((from == null || "".equals(from)) ? 0 : Integer.parseInt(from));
        settingsRequest.setTo((to == null || "".equals(to)) ? 0 : Integer.parseInt(to));
        settingsRequest.setSearchParameters(searchParameters);
        return getAllWinePositions(settingsRequest);
    }

    @ApiOperation(value = "Get all wine positions true",
            nickname = "getAllWinePositionsTrue", notes = "",
            tags = {"wine-position-true-controller",})
    @GetMapping("/trueSettings")
    public List<WinePositionTrueResponse> getAllWinePositionsTrue(
            @RequestParam(required = false) String page,
            @RequestParam(required = false) String amount,
            @RequestParam(required = false) List<String> sortByPair,
            @RequestParam(required = false) String filterBy
    ) {
        SettingsRequest settingsRequest = new SettingsRequest();
        if (sortByPair != null) {
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
            settingsRequest.setSortBy(collect);
        }
        settingsRequest.setFrom((page == null || "".equals(page)) ? 0 : Integer.parseInt(page));
        settingsRequest.setTo((amount == null || "".equals(amount)) ? 0 : Integer.parseInt(amount));
        settingsRequest.setSearchParameters(filterBy);
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
        WineTrueResponse trueWineById = wineTrueController.getWineById(wineById.getWine_id());
        winePositionTrueResponse.setWineTrueResponse(trueWineById);
        List<RegionResponse> regionResponse = trueWineById.getRegionResponse();
        if(regionResponse.size()>0) {
            winePositionTrueResponse.setCountry(regionResponse.get(0).getCountry());
        }else{
            winePositionTrueResponse.setCountry("");
        }
        return winePositionTrueResponse;
    }
}
