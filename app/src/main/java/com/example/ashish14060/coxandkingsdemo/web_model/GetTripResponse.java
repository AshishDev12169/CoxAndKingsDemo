package com.example.ashish14060.coxandkingsdemo.web_model;

import java.util.ArrayList;

/**
 * Created by Ashish14060 on 5/28/2018.
 */

public class GetTripResponse extends MasterResponse
{
    public ArrayList<Trip> trips = new ArrayList<>();

    public ArrayList<Trip> getTrips() {
        return trips;
    }

    public void setTrips(ArrayList<Trip> trips) {
        this.trips = trips;
    }
}
