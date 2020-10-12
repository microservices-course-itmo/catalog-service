package com.wine.to.up.catalog.service.service;

import java.util.List;

public interface BaseCrudService<T> {
    List<T> readAll();

    void create(T t);

    T read(String id);

    void update(String id, T t);

    void delete(String id);
}
