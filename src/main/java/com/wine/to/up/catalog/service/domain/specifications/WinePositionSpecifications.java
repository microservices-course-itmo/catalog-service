package com.wine.to.up.catalog.service.domain.specifications;

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
}
