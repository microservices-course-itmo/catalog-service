package com.wine.to.up.catalog.service.service;

public interface BaseCrudService<T> {
    void create(T t);

    T read(String id);

    void update(String id, T t);

    void delete(String id);
}
