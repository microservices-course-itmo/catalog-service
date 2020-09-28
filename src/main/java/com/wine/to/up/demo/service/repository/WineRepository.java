package com.wine.to.up.demo.service.repository;

import com.wine.to.up.demo.service.domain.entities.*;
import org.springframework.stereotype.Repository;


@Repository
public interface WineRepository {
    Grapes findGrapesByID(int grapesId);
    WineGrapesInfo findWineGrapesInfoByID(int wineGrapesInfoID);
    Wine findWineByID(int wineID);
    Catalog findCatalogByID(int winePositionID);
    Shop findShopByID(int shopID);
    Country findCountryByID(int countryID);
    Brand findBrandByID(int brandID);
}
