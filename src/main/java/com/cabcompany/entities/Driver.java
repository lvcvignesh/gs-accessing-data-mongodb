package com.cabcompany.entities;

import com.cabcompany.StatusConstants;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;
import com.mysema.query.annotations.QueryEntity;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Kishan on 7/8/2016.
 */
@QueryEntity
@Document
public class Driver {

    @Id
    private String id;
    private String name;
    private StatusConstants.DriverStatus driverStatus;
    private String CurrentTripID;
    private String ResidentialAddress;
    private GeoJsonPoint residentialAddressLocation;
    private String VehicleModel;
    private String VehicleType;
    private String VehicleRegnNo;
    // private String DriverImage; - Base64 Encoded String LATER, BUT NEEDED
    @GeoSpatialIndexed(type = GeoSpatialIndexType.GEO_2DSPHERE)
    private GeoJsonPoint currentLocation;
    private boolean locationIntegrity;

    public Driver() {
    }

    public Driver(String name, String residentialAddress, String vehicleModel, String vehicleRegnNo, String vehicleType) throws Exception {
        setName(name);
        setResidentialAddress(residentialAddress);
        GeoApiContext context = new GeoApiContext().setApiKey("AIzaSyDgpKTXPQ1tXVQN6HFZxvTBUsyumto2DjA");
        GeocodingResult[] results = GeocodingApi.geocode(context, residentialAddress).await();
        for (GeocodingResult result : results)
            System.out.println(result.geometry.location + "\t" + result.geometry.locationType);
        if (results.length > 0) {
            setResidentialAddressLocation(new GeoJsonPoint(results[0].geometry.location.lng, results[0].geometry.location.lat));
            setCurrentLocation(getResidentialAddressLocation());
        }
        setVehicleModel(vehicleModel);
        setVehicleRegnNo(vehicleRegnNo);
        setVehicleType(vehicleType);
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

    public String getCurrentTripID() {
        return CurrentTripID;
    }

    public void setCurrentTripID(String currentTripID) {
        CurrentTripID = currentTripID;
    }

    public String getResidentialAddress() {
        return ResidentialAddress;
    }

    public void setResidentialAddress(String residentialAddress) {
        ResidentialAddress = residentialAddress;
    }

    public GeoJsonPoint getResidentialAddressLocation() {
        return residentialAddressLocation;
    }

    public void setResidentialAddressLocation(GeoJsonPoint residentialAddressLocation) {
        this.residentialAddressLocation = residentialAddressLocation;
    }

    public String getVehicleRegnNo() {
        return VehicleRegnNo;
    }

    public void setVehicleRegnNo(String vehicleRegnNo) {
        VehicleRegnNo = vehicleRegnNo;
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

    public StatusConstants.DriverStatus getDriverStatus() {
        return driverStatus;
    }

    public void setDriverStatus(StatusConstants.DriverStatus driverStatus) {
        this.driverStatus = driverStatus;
    }

    public String getVehicleModel() {
        return VehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        VehicleModel = vehicleModel;
    }

    public String getVehicleType() {
        return VehicleType;
    }

    public void setVehicleType(String vehicleType) {
        VehicleType = vehicleType;
    }

    @Override
    public String toString() {
        return String.format(
                "Driver[id=%s, name='%s', Address='%s' Location=%s]",
                id, getName(), getResidentialAddress(), getCurrentLocation());
    }
}
