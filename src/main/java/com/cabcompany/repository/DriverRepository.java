package com.cabcompany.repository;

import com.cabcompany.entities.Driver;
import org.springframework.data.geo.Circle;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by Kishan on 7/8/2016.
 */
public interface DriverRepository extends MongoRepository<Driver, String> {
    Driver findByname(String name);

    List<Driver> findByCurrentLocationWithin(Circle c);

    List<Driver> findByCurrentLocationNear(Point p, Distance d);

    Driver findById(String name);
}
