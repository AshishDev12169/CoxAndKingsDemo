package com.example.ashish14060.coxandkingsdemo.web_model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by Ashish14060 on 5/28/2018.
 */

public class Trip extends MasterResponse implements Parcelable {
    private String tripId;
    private String name;
    private String startDate;
    private String endDate;


    private ArrayList<Itinerary> itinerary = new ArrayList<Itinerary>();

    public String getTripId() {
        return tripId;
    }

    public void setTripId(String tripId) {
        this.tripId = tripId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public ArrayList<Itinerary> getListOfItinerary() {
        return itinerary;
    }

    public void setListOfItinerary(ArrayList<Itinerary> listOfItinerary) {
        this.itinerary = listOfItinerary;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.tripId);
        dest.writeString(this.name);
        dest.writeString(this.startDate);
        dest.writeString(this.endDate);
        dest.writeList(this.itinerary);
    }

    public Trip() {
    }

    protected Trip(Parcel in) {
        this.tripId = in.readString();
        this.name = in.readString();
        this.startDate = in.readString();
        this.endDate = in.readString();
        this.itinerary = new ArrayList<Itinerary>();
        in.readList(this.itinerary, Itinerary.class.getClassLoader());
    }

    public static final Parcelable.Creator<Trip> CREATOR = new Parcelable.Creator<Trip>() {
        @Override
        public Trip createFromParcel(Parcel source) {
            return new Trip(source);
        }

        @Override
        public Trip[] newArray(int size) {
            return new Trip[size];
        }
    };
}
