package com.wine.to.up.demo.service;

import com.wine.to.up.demo.service.domain.entities.Brand;
import com.wine.to.up.demo.service.domain.entities.Country;
import com.wine.to.up.demo.service.domain.entities.Wine;
import com.wine.to.up.demo.service.domain.enums.Color;
import com.wine.to.up.demo.service.domain.enums.Sugar;
import com.wine.to.up.demo.service.repository.WineRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan("com.wine.to.up")
@EnableSwagger2
public class ServiceApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(ServiceApplication.class, args);
        test(run.getBean(WineRepository.class));
        System.out.println();
    }

    public static void test(WineRepository wineRepository) {
        Wine wine = new Wine();
        wine.setPicture(new byte[]{1, 1, 1, 1});
        Brand b = new Brand();
        b.setBrandName("asabina");
        wine.setBrand(b);
        Country c = new Country();
        c.setCountryName("Russia");
        wine.setCountry(c);
        wine.setVolume(0.5f);
        wine.setStrength(0.5f);
        wine.setColor(Color.RED);
        wine.setSugar(Sugar.DRY);
        wineRepository.save(wine);
        System.out.println(wine);
        wineRepository.findWineBywineID(wine.getWineID());
    }

}
