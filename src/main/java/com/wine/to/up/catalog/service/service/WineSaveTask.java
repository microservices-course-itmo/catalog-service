package com.wine.to.up.catalog.service.service;

import com.wine.to.up.parser.common.api.schema.ParserApi;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WineSaveTask implements Runnable{

    public WineSaveTask(WineSaveService wineSaveService, ParserApi.WineParsedEvent wineParsedEvent){
        wineSaveService.save(wineParsedEvent);
    }

    @Override
    public void run() {
        log.info("PROCESSING WINE_PARSED_EVENT STARTED");
    }
}
