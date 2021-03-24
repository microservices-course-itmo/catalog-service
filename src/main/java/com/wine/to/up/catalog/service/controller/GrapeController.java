package com.wine.to.up.catalog.service.controller;


import com.wine.to.up.catalog.service.domain.request.GrapeRequest;
import com.wine.to.up.catalog.service.domain.response.GrapeResponse;
import com.wine.to.up.catalog.service.mapper.controller2service.GrapeControllerToGrapeService;
import com.wine.to.up.catalog.service.service.GrapeService;
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
@RequestMapping("/grape")
@Validated
@Slf4j
@Api(value = "GrapeController", description = "Grape controller")
public class GrapeController {

    private final GrapeService grapeService;
    private final GrapeControllerToGrapeService converter;

    @GetMapping("/{id}")
    public GrapeResponse getGrapeById(@Valid @PathVariable(name = "id") String grapeId) {
        return converter.convert(grapeService.read(grapeId));
    }

    @GetMapping("/")
    public List<GrapeResponse> getAllGrapes() {
        return grapeService.readAll()
                .stream()
                .map(converter::convert)
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public void updateGrape(@Valid @PathVariable(name = "id") String grapeId,
                            @Valid @RequestBody GrapeRequest grapeRequest) {
        grapeService.update(grapeId, converter.convert(grapeRequest));
    }

    @PostMapping("/")
    public void createGrape(@Valid @RequestBody GrapeRequest grapeRequest) {
        grapeService.create(converter.convert(grapeRequest));
    }
}
