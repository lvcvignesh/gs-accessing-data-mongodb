package com.cabcompany.services;

import com.cabcompany.entities.Request;
import com.cabcompany.entities.Trip;
import com.cabcompany.repository.RequestRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.stereotype.Service;

/**
 * Created by Kishan on 7/14/2016.
 */
@Service
public class RequestPollService {
    Logger logger = LoggerFactory.getLogger(RequestPollService.class);
    @Autowired
    private RequestRepository requestRepository;

    public Request getTrip(String driverID) {
        try {
            logger.info("Inside AsyncTask");
            Thread.sleep(5000);
            logger.info("5 second Delayed and Request sent to " + driverID);
            Request request = new Request("1234", new GeoJsonPoint(1, 1));
            requestRepository.save(request);
            return request;
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
    }
}
