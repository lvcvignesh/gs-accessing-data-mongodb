package com.cabcompany.controllers;

import com.cabcompany.entities.Request;
import com.cabcompany.entities.Trip;
import com.cabcompany.repository.RequestRepository;
import com.cabcompany.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Kishan on 7/11/2016.
 */
@RestController
public class RequestController {
    @Autowired
    private RequestRepository requestRepository;
    @Autowired
    private TripRepository tripRepository;

    @RequestMapping(value = "/request/{requestID}/response", method = RequestMethod.PUT)
    public Trip RequestResponse(@PathVariable("requestID") String id, @RequestParam("response") boolean response, @RequestParam("driverID") String driverID) {
        Request request = requestRepository.findById(id);
        if (response) {
            Trip trip = new Trip(request.getId(), request.getCusomertID(), driverID, request.getStartLocation());
            tripRepository.save(trip);
            return trip;
        }
        return null;
    }

}
