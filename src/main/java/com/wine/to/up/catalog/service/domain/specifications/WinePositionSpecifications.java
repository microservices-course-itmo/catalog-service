package com.wine.to.up.catalog.service.domain.specifications;

import com.wine.to.up.catalog.service.domain.entities.WinePosition;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class WinePositionSpecifications {

    public static Specification<WinePosition> winePositionHasWebsiteLink() {
        return new Specification<WinePosition>() {
            @Override
            public Predicate toPredicate(Root<WinePosition> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.notEqual(root.get("linkToWine"), "");
            }
        };
    }

    public static Specification<WinePosition> winePositionHasImage() {
        return new Specification<WinePosition>() {
            @Override
            public Predicate toPredicate(Root<WinePosition> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.notEqual(root.get("image"), null);
            }
        };
    }

    public static Specification<WinePosition> winePositionVolumeIsLessThan(float requestVolume){
        return new Specification<WinePosition>() {
            @Override
            public Predicate toPredicate(Root<WinePosition> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.lessThan(root.get("volume"), requestVolume);
            }
        };
    }

    public static Specification<WinePosition> winePositionVolumeIsGreaterThan(float requestVolume){
        return new Specification<WinePosition>() {
            @Override
            public Predicate toPredicate(Root<WinePosition> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.greaterThan(root.get("volume"), requestVolume);
            }
        };
    }
}
