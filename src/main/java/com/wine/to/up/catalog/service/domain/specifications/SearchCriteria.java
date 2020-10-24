package com.wine.to.up.catalog.service.domain.specifications;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
public class SearchCriteria {
    private String key;
    private String operation;
    private Object value;
    public boolean isOrPredicate;

    public SearchCriteria(String key, String operation, Object value){
        this.key = key;
        this.operation = operation;
        this.value = value;
        this.isOrPredicate = Boolean.parseBoolean(null);
    }
}

