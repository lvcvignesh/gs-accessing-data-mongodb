package com.cabcompany.repository;

import com.cabcompany.entities.Trip;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Kishan on 7/11/2016.
 */
public interface TripRepository extends MongoRepository<Trip, String> {
}
