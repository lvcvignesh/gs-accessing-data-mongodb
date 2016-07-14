package com.cabcompany.repository;

import com.cabcompany.entities.Request;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Kishan on 7/11/2016.
 */
public interface RequestRepository extends MongoRepository<Request, String> {
    public Request findById(String id);

}
