package com.cabcompany.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;

/**
 * Created by Kishan on 7/11/2016.
 */
public class Trip {
    @Id
    private String id;
    private String customerID;
    private String driverID;
    private String requestID;
    private GeoJsonPoint startLocation;

}
