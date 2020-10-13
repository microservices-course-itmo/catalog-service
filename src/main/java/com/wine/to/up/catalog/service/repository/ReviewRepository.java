package com.wine.to.up.catalog.service.repository;

import com.wine.to.up.catalog.service.domain.entities.Review;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ReviewRepository {
    List<Review> findAllByWineID(String wineID);
    List<Review> findAllByUserID(String userID);
}
