package com.cabcompany.controllers;

import java.util.List;

import com.cabcompany.entities.QDriver;
import com.cabcompany.repository.DriverRepository;
import com.cabcompany.entities.Driver;
import com.mysema.query.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Circle;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.MongoTemplate;
import  org.springframework.data.mongodb.core.query.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class DriverController {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private DriverRepository repository;
    @CrossOrigin()
    @RequestMapping("/drivers")
    public List<Driver> getAll(){
        return repository.findAll();
    }
    @RequestMapping("/driver")
    public List<Driver> getDriversNearby(@RequestParam("lat") String lat,@RequestParam("lng") String lng,@RequestParam("distance") String distance) {
        Point p=new Point(Double.parseDouble(lng),Double.parseDouble(lat));
        Query query = Query.query(Criteria.where("currentLocation").withinSphere(new Circle(p, new Distance(Double.parseDouble(distance),Metrics.KILOMETERS).getNormalizedValue())));
        return mongoTemplate.find(query,Driver.class);
    }
}