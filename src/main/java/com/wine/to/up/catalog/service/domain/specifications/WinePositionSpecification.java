package com.wine.to.up.catalog.service.domain.specifications;

import com.wine.to.up.catalog.service.domain.entities.WinePosition;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.Arrays;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class WinePositionSpecification implements Specification<WinePosition> {
    private SearchCriteria criteria;

    private Path<String> findPath(Root<WinePosition> root, String attribute) {
        String[] split = attribute.split("\\.");
        Path<String> result = null;

        for (String s : split) {
            if (result == null) {
                result = root.get(s);
            } else {
                result = result.get(s);
            }
        }
        return result;
    }

    @Override
    public Predicate toPredicate(Root<WinePosition> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        if (criteria.getOperation().equalsIgnoreCase(">")) {
            return criteriaBuilder.greaterThanOrEqualTo(findPath(root, criteria.getKey()), criteria.getValue().toString());
        } else if (criteria.getOperation().equalsIgnoreCase("<")) {
            return criteriaBuilder.lessThanOrEqualTo(findPath(root, criteria.getKey()), criteria.getValue().toString());
        } else if (criteria.getOperation().equalsIgnoreCase(":")) {
            if (findPath(root, criteria.getKey()).getJavaType() == String.class) {
                return criteriaBuilder.like(findPath(root, criteria.getKey()), "%" + criteria.getValue() + "%");
            } else {
                return criteriaBuilder.equal(findPath(root, criteria.getKey()), criteria.getValue());
            }
        } else if (criteria.getOperation().equalsIgnoreCase("~")) {
            this.criteria.setOrPredicate(true);
            return criteriaBuilder.or();
        } else if (criteria.getOperation().equalsIgnoreCase("*")) {
            this.criteria.setOrPredicate(false);
            return criteriaBuilder.and();
        }
        return null;
    }
}
