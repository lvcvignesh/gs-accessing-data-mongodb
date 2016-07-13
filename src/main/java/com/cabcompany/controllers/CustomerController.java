package com.cabcompany.controllers;

import com.cabcompany.entities.Customer;
import com.cabcompany.entities.Driver;
import com.cabcompany.repository.CustomerRepository;
import com.cabcompany.repository.DriverRepository;
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

/**
 * Created by Kishan on 7/11/2016.
 */
public class CustomerController {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private CustomerRepository repository;

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public List<Customer> getAll() {
        return repository.findAll();
    }

    @RequestMapping(value = "/customers/{customerID}", method = RequestMethod.GET)
    public Customer getCustomerbyID(@PathVariable("customerID") String id) {
        return repository.findById(id);
    }

    @RequestMapping(value = "/customers/", method = RequestMethod.POST)
    public Customer addDriver(@RequestBody Customer customer) {
        repository.save(customer);
        return customer;
    }

    @RequestMapping(value = "/customer/{customerID}", method = RequestMethod.PUT)
    public Customer updateDriver(@PathVariable("customerID") String id, @RequestBody Customer customer) {
        repository.save(customer);
        return customer;
    }

    @RequestMapping(value = "/customers/{customerID}/location", method = RequestMethod.PUT)
    public Customer updateLocation(@PathVariable("customerID") String id, @RequestParam("lat") Double lat, @RequestParam("lng") Double lng) {
        Customer customer = repository.findById(id);
        customer.setCurrentLocation(new GeoJsonPoint(lng, lat));
        customer.setLocationIntegrity(true);
        repository.save(customer);
        return customer;
    }

    @RequestMapping(value = "/customers/near", method = RequestMethod.GET)
    public List<GeoJsonPoint> getDriversNearby(@RequestParam("lat") String lat, @RequestParam("lng") String lng, @RequestParam("distance") String distance) {
        Point p = new Point(Double.parseDouble(lng), Double.parseDouble(lat));
        Query query = Query.query(Criteria.where("currentLocation").withinSphere(new Circle(p, new Distance(Double.parseDouble(distance), Metrics.KILOMETERS).getNormalizedValue())));
        List<GeoJsonPoint> geoJsonPoints = new ArrayList<>();
        for (Driver driver : mongoTemplate.find(query, Driver.class))
            geoJsonPoints.add(driver.getCurrentLocation());
        return geoJsonPoints;
    }
}
