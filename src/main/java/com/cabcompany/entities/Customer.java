package com.cabcompany.entities;

import com.cabcompany.StatusConstants;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Kishan on 7/11/2016.
 */
@Document
public class Customer {
    @Id
    @Indexed
    private String id;
    private String name;
    private StatusConstants.CustomerStatus customerStatus;
    private String CurrentTripID;
    private String mobileNo;

    // private String CustomerImage; - Base64 Encoded String LATER, BUT NEEDED
    @GeoSpatialIndexed(type = GeoSpatialIndexType.GEO_2DSPHERE)
    private GeoJsonPoint currentLocation;
    private boolean locationIntegrity;

    public Customer() {
    }

    public Customer(String name, String mobileNo) {
        setName(name);
        setMobileNo(mobileNo);
        setLocationIntegrity(false);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StatusConstants.CustomerStatus getCustomerStatus() {
        return customerStatus;
    }

    public void setCustomerStatus(StatusConstants.CustomerStatus customerStatus) {
        this.customerStatus = customerStatus;
    }

    public String getCurrentTripID() {
        return CurrentTripID;
    }

    public void setCurrentTripID(String currentTripID) {
        CurrentTripID = currentTripID;
    }

    public GeoJsonPoint getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(GeoJsonPoint currentLocation) {
        this.currentLocation = currentLocation;
    }

    public boolean isLocationIntegrity() {
        return locationIntegrity;
    }

    public void setLocationIntegrity(boolean locationIntegrity) {
        this.locationIntegrity = locationIntegrity;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

}
