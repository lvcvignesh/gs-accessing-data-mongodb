package com.cabcompany.repository;

import com.cabcompany.entities.Customer;
import com.cabcompany.entities.Driver;
import org.springframework.data.geo.Circle;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by Kishan on 7/11/2016.
 */
public interface CustomerRepository extends MongoRepository<Customer, String> {
    Customer findByname(String name);

    Customer findById(String name);
}
