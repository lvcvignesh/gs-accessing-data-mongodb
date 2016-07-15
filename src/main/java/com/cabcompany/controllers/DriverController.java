package com.cabcompany.controllers;

import com.cabcompany.entities.Driver;
import com.cabcompany.entities.Request;
import com.cabcompany.entities.Trip;
import com.cabcompany.repository.DriverRepository;
import com.cabcompany.services.RequestPollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Circle;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

@RestController
@CrossOrigin
public class DriverController {
    @Autowired
    RequestPollService requestPollService;
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private DriverRepository repository;

    @RequestMapping(value = "/drivers", method = RequestMethod.GET)
    public List<Driver> getAll() {
        return repository.findAll();
    }

    @RequestMapping(value = "/drivers/{driverID}", method = RequestMethod.GET)
    public Driver getDriverbyID(@PathVariable("driverID") String id) {
        return repository.findById(id);
    }

    @RequestMapping(value = "/drivers/", method = RequestMethod.POST)
    public Driver addDriver(@RequestBody Driver driver) {
        repository.save(driver);
        return driver;
    }

    @RequestMapping(value = "/drivers/{driverID}", method = RequestMethod.POST)
    public Driver updateDriver(@PathVariable("id") String id, @RequestBody Driver driver) {
        repository.save(driver);
        return driver;
    }

    @RequestMapping(value = "/drivers/{driverID}/location", method = RequestMethod.GET)
    public Driver updateLocation(@PathVariable("driverID") String id, @RequestParam("lat") Double lat, @RequestParam("lng") Double lng) {
        Driver driver = repository.findById(id);
        driver.setCurrentLocation(new GeoJsonPoint(lng, lat));
        driver.setLocationIntegrity(true);
        repository.save(driver);
        return driver;
    }

    @RequestMapping(value = "/drivers/{driverID}/poll", method = RequestMethod.GET)
    public Callable<Request> pollDriver(@PathVariable("driverID") String id) {
        Callable<Request> asyncTask = new Callable<Request>() {
            @Override
            public Request call() throws Exception {
                return requestPollService.getTrip(id);
            }
        };
        return asyncTask;
    }
    @RequestMapping("/drivers/near")
    public List<GeoJsonPoint> getDriversNearby(@RequestParam("lat") String lat, @RequestParam("lng") String lng, @RequestParam("distance") String distance) {
        Point p = new Point(Double.parseDouble(lng), Double.parseDouble(lat));
        Query query = Query.query(Criteria.where("currentLocation").withinSphere(new Circle(p, new Distance(Double.parseDouble(distance), Metrics.KILOMETERS).getNormalizedValue())));
        List<GeoJsonPoint> geoJsonPoints = new ArrayList<>();
        for (Driver driver : mongoTemplate.find(query, Driver.class))
            geoJsonPoints.add(driver.getCurrentLocation());
        return geoJsonPoints;
    }
}