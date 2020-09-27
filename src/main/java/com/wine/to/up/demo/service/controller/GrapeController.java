package com.wine.to.up.demo.service.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/grape")
@Validated
@Slf4j
public class GrapeController {
    @GetMapping("/{id}")
    public void getGrapeById(){
    }

    @GetMapping("/")
    public void getAllGrapes(){
    }

    @PutMapping("/{id}")
    public void updateGrape(){

    }

    @PostMapping("/")
    public void createGrape(){

    }
}
