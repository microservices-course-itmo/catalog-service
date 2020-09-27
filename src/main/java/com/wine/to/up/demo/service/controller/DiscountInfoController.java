package com.wine.to.up.demo.service.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/discountinfo")
@Validated
@Slf4j
public class DiscountInfoController {
    @PostMapping("/")
    public void createDiscountInfo(){

    }

    @GetMapping("/{id}")
    public void getDiscountInfoById(){
    }

    @PutMapping("/{id}")
    public void updateDiscountInfoById(){

    }
}
