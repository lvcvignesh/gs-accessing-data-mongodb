package com.cabcompany.entities;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;

import java.util.Calendar;

/**
 * Created by Kishan on 7/11/2016.
 */
public class Request {
    @Id
    private String id;
    private String cusomertID;
    private GeoJsonPoint startLocation;
    private GeoJsonPoint endLocation;
    private Long distance;

    public Request() {
    }

    public Request(String customerID, GeoJsonPoint startLocation, GeoJsonPoint endLocation) {
        setCusomertID(customerID);
        setStartLocation(startLocation);
        setEndLocation(endLocation);
    }

    public Request(String cusomertID, GeoJsonPoint startLocation) {
        setCusomertID(cusomertID);
        setStartLocation(startLocation);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCusomertID() {
        return cusomertID;
    }

    public void setCusomertID(String cusomertID) {
        this.cusomertID = cusomertID;
    }

    public GeoJsonPoint getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(GeoJsonPoint startLocation) {
        this.startLocation = startLocation;
    }

    public GeoJsonPoint getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(GeoJsonPoint endLocation) {
        this.endLocation = endLocation;
    }

    public Long getDistance() {
        return distance;
    }

    public void setDistance(Long distance) {
        this.distance = distance;
    }
}
