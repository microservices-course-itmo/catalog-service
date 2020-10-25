package com.wine.to.up.catalog.service.domain.specifications;

import com.wine.to.up.catalog.service.domain.entities.WinePosition;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WinePositionSpecificationBuilder {
    private final List<SearchCriteria> parameters;

    public WinePositionSpecificationBuilder(){
        parameters = new ArrayList<>();
    }

    public WinePositionSpecificationBuilder with(String key, String operation, Object value){
        parameters.add(new SearchCriteria(key, operation, value));
        return this;
    }

    public Specification<WinePosition> build(){
        if (parameters.size() == 0){
            return null;
        }

        List<Specification<WinePosition>> specifications = parameters.stream()
                .map(WinePositionSpecification::new)
                .collect(Collectors.toList());

        Specification<WinePosition> result = specifications.get(0);

        for (int i = 1; i < parameters.size(); i++) {
            result = parameters.get(i).isOrPredicate
                    ? Specification.where(result).or(specifications.get(i))
                    : Specification.where(result).and(specifications.get(i));
        }

        return result;
    }
}
