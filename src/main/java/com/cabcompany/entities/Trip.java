package com.cabcompany.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Calendar;

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
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Calendar requesttimestamp;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getDriverID() {
        return driverID;
    }

    public void setDriverID(String driverID) {
        this.driverID = driverID;
    }

    public String getRequestID() {
        return requestID;
    }

    public void setRequestID(String requestID) {
        this.requestID = requestID;
    }

    public GeoJsonPoint getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(GeoJsonPoint startLocation) {
        this.startLocation = startLocation;
    }

    public Calendar getRequesttimestamp() {
        return requesttimestamp;
    }

    public void setRequesttimestamp(Calendar requesttimestamp) {
        this.requesttimestamp = requesttimestamp;
    }

}
