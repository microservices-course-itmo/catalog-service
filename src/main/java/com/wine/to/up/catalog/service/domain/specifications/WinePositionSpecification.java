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
        String key = criteria.getKey();
        boolean isOrPredicate = "~".equals(key.substring(0,1));
        boolean isAndPredicate = "*".equals(key.substring(0,1));
        if(isAndPredicate||isOrPredicate){
            key = key.substring(1);
        }

        if (isOrPredicate) {
            this.criteria.setOrPredicate(true);
        } else if (isAndPredicate) {
            this.criteria.setOrPredicate(false);
        }

        if (criteria.getOperation().equalsIgnoreCase(">")) {
            return criteriaBuilder.greaterThanOrEqualTo(findPath(root, key), criteria.getValue().toString());
        } else if (criteria.getOperation().equalsIgnoreCase("<")) {
            return criteriaBuilder.lessThanOrEqualTo(findPath(root, key), criteria.getValue().toString());
        } else if (criteria.getOperation().equalsIgnoreCase(":")) {
            if (findPath(root, key).getJavaType() == String.class) {
                return criteriaBuilder.like(findPath(root, key), "%" + criteria.getValue() + "%");
            } else {
                return criteriaBuilder.equal(findPath(root, key), criteria.getValue());
            }
        }
        return null;
    }
}
