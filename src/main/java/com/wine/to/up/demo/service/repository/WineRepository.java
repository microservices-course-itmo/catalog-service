package com.wine.to.up.demo.service.repository;

import com.wine.to.up.demo.service.domain.entities.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface WineRepository extends CrudRepository<Wine, Integer> {
    Wine findWineBywineID(int wineID);
}
