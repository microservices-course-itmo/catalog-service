package com.wine.to.up.catalog.service.domain.specifications;

import com.wine.to.up.catalog.service.domain.entities.Shop;
import com.wine.to.up.catalog.service.domain.entities.Wine;
import com.wine.to.up.catalog.service.domain.entities.WinePosition;
import org.springframework.data.jpa.domain.Specification;

public class WinePositionSpecifications {

    public static Specification<WinePosition> winePositionHasWebsiteLink() {
        return (Specification<WinePosition>) (root, query, criteriaBuilder) -> criteriaBuilder.notEqual(root.get("linkToWine"), "");
    }

    public static Specification<WinePosition> winePositionHasImage() {
        return (Specification<WinePosition>) (root, query, criteriaBuilder) -> criteriaBuilder.notEqual(root.get("image"), null);
    }

    public static Specification<WinePosition> winePositionVolumeIsLessThan(float requestVolume){
        return (Specification<WinePosition>) (root, query, criteriaBuilder) -> criteriaBuilder.lessThan(root.get("volume"), requestVolume);
    }

    public static Specification<WinePosition> winePositionVolumeIsGreaterThan(float requestVolume){
        return (Specification<WinePosition>) (root, query, criteriaBuilder) -> criteriaBuilder.greaterThan(root.get("volume"), requestVolume);
    }

    public static Specification<WinePosition> winePositionActualPriceLessThan(float requestActualPrice){
        return (Specification<WinePosition>) (root, query, criteriaBuilder) -> criteriaBuilder.lessThan(root.get("actual_price"), requestActualPrice);
    }

    public static Specification<WinePosition> winePositionActualPriceGreaterThan(float requestActualPrice){
        return (Specification<WinePosition>) (root, query, criteriaBuilder) -> criteriaBuilder.greaterThan(root.get("actual_price"), requestActualPrice);
    }

    public static Specification<WinePosition> winePositionHasShop(Shop shop){
        return (Specification<WinePosition>) (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("shop"), shop);
    }

    public static Specification<WinePosition> winePositionHasWine(Wine wine){
        return (Specification<WinePosition>) (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("wpWine"), wine);
    }
}