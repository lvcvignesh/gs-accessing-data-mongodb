package com.cabcompany;

/**
 * Created by Kishan on 7/8/2016.
 */
public class StatusConstants {
    //Random status set
    public enum DriverStatus {
        WAITING_FOR_TRIP, ACCEPTED_TRIP, WAITING_FOR_CUSTOMER, TRIP_STARTED, TRIP_ENDED, INACTIVE, FARE_COLLECTED
    }

    public enum CustomerStatus {
        ACTIVE, REQUESTING_TRIP, WAITING_FOR_TRIP, CANCELLED_LAST_TRIP, TRIP_STARTED, TRIP_ENDED, FARE_PAID
    }
}
