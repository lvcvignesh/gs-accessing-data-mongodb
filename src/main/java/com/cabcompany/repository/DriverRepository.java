package com.cabcompany.repository;

import com.cabcompany.entities.Driver;
import com.cabcompany.entities.QDriver;
import org.springframework.data.geo.Circle;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import java.util.List;

/**
 * Created by Kishan on 7/8/2016.
 */
public interface DriverRepository  extends MongoRepository<Driver, String>,QueryDslPredicateExecutor<Driver> {
    public Driver findByname(String name);
    public List<Driver> findByCurrentLocationWithin(Circle c);
    public List<Driver> findByCurrentLocationNear(Point p,Distance d);

}
