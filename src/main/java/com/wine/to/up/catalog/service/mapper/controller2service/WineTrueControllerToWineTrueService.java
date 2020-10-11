package com.wine.to.up.catalog.service.mapper.controller2service;

import com.wine.to.up.catalog.service.domain.request.GrapeRequest;
import com.wine.to.up.catalog.service.domain.request.WineRequest;
import com.wine.to.up.catalog.service.domain.request.WineTrueRequest;
import com.wine.to.up.catalog.service.domain.response.GrapeResponse;
import com.wine.to.up.catalog.service.domain.response.WineResponse;
import com.wine.to.up.catalog.service.domain.response.WineTrueResponse;
import org.springframework.stereotype.Component;

@Component
public class WineTrueControllerToWineTrueService {
    public void convert(WineTrueRequest wineTrueRequest) {
    }

    public WineTrueResponse convert() {
        return new WineTrueResponse();
    }
}
