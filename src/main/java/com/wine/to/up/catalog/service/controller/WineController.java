package com.wine.to.up.catalog.service.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/position")
@Validated
@Slf4j
public class WineController {
    @GetMapping("/{id}")
    public void getWinePositionById(){
    }

    @GetMapping("/")
    public void getAllWinePostions(){
    }

    @PostMapping("/")
    public void createWinePosition(){

    }

    @PutMapping("/{id}")
    public void updateWinePosition(){

    }
}
