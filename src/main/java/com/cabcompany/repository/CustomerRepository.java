package com.cabcompany.repository;

import com.cabcompany.entities.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Kishan on 7/11/2016.
 */
public interface CustomerRepository extends MongoRepository<Customer, String> {

}
