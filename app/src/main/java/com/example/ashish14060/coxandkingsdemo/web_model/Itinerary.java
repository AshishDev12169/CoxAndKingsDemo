package com.example.ashish14060.coxandkingsdemo.web_model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Ashish14060 on 5/28/2018.
 */

public class Itinerary implements Parcelable
{
    private String vehicleNumber;
    private int typeId;
    private String type;

    private String sourceAirportCode;
    private String destinationAirportCode;
    private String provider;
    private String source;
    private String destination;
    private String date;
    private String journeyStartDateTime;
    private String journeyEndDateTime;
    private String imageUrl;
    private String address;
    private String pnrNumber;

    public String getPnrNumber() {
        return pnrNumber;
    }

    public void setPnrNumber(String pnrNumber) {
        this.pnrNumber = pnrNumber;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }


    private String hotelName;

    public String getContactPersonPhoneNumber() {
        return contactPersonPhoneNumber;
    }

    public void setContactPersonPhoneNumber(String contactPersonPhoneNumber) {
        this.contactPersonPhoneNumber = contactPersonPhoneNumber;
    }

    private String checkInDate;
    private String checkOutDate;

    public String getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    private String contactPersonName;
    private String contactPersonPhoneNumber;
    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(String checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public String getContactPersonName() {
        return contactPersonName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setContactPersonName(String contactPersonName) {
        this.contactPersonName = contactPersonName;
    }

    private String itineraryId;

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }


    // Getter Methods
    public String getItineraryId() {
        return itineraryId;
    }
    public String getType() {
        return type;
    }

    public String getSourceAirportCode() {
        return sourceAirportCode;
    }

    public String getDestinationAirportCode() {
        return destinationAirportCode;
    }

    public String getProvider() {
        return provider;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public String getDate() {
        return date;
    }

    public String getJourneyStartDateTime() {
        return journeyStartDateTime;
    }

    public String getJourneyEndDateTime() {
        return journeyEndDateTime;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    // Setter Methods

    public void setItineraryId( String itineraryId ) {
        this.itineraryId = itineraryId;
    }

    public void setType( String type ) {
        this.type = type;
    }

    public void setSourceAirportCode(String sourceAirportCode) {
        this.sourceAirportCode = sourceAirportCode;
    }

    public void setDestinationAirportCode(String destinationAirportCode) {
        this.destinationAirportCode = destinationAirportCode;
    }

    public void setProvider( String provider ) {
        this.provider = provider;
    }

    public void setSource( String source ) {
        this.source = source;
    }

    public void setDestination( String destination ) {
        this.destination = destination;
    }

    public void setDate( String date ) {
        this.date = date;
    }

    public void setJourneyStartDateTime( String journeyStartDateTime ) {
        this.journeyStartDateTime = journeyStartDateTime;
    }

    public void setJourneyEndDateTime( String journeyEndDateTime ) {
        this.journeyEndDateTime = journeyEndDateTime;
    }

    public void setImageUrl( String imageUrl ) {
        this.imageUrl = imageUrl;
    }

    public Itinerary() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.vehicleNumber);
        dest.writeInt(this.typeId);
        dest.writeString(this.type);
        dest.writeString(this.sourceAirportCode);
        dest.writeString(this.destinationAirportCode);
        dest.writeString(this.provider);
        dest.writeString(this.source);
        dest.writeString(this.destination);
        dest.writeString(this.date);
        dest.writeString(this.journeyStartDateTime);
        dest.writeString(this.journeyEndDateTime);
        dest.writeString(this.imageUrl);
        dest.writeString(this.address);
        dest.writeString(this.pnrNumber);
        dest.writeString(this.hotelName);
        dest.writeString(this.checkInDate);
        dest.writeString(this.checkOutDate);
        dest.writeString(this.contactPersonName);
        dest.writeString(this.contactPersonPhoneNumber);
        dest.writeString(this.itineraryId);
    }

    protected Itinerary(Parcel in) {
        this.vehicleNumber = in.readString();
        this.typeId = in.readInt();
        this.type = in.readString();
        this.sourceAirportCode = in.readString();
        this.destinationAirportCode = in.readString();
        this.provider = in.readString();
        this.source = in.readString();
        this.destination = in.readString();
        this.date = in.readString();
        this.journeyStartDateTime = in.readString();
        this.journeyEndDateTime = in.readString();
        this.imageUrl = in.readString();
        this.address = in.readString();
        this.pnrNumber = in.readString();
        this.hotelName = in.readString();
        this.checkInDate = in.readString();
        this.checkOutDate = in.readString();
        this.contactPersonName = in.readString();
        this.contactPersonPhoneNumber = in.readString();
        this.itineraryId = in.readString();
    }

    public static final Creator<Itinerary> CREATOR = new Creator<Itinerary>() {
        @Override
        public Itinerary createFromParcel(Parcel source) {
            return new Itinerary(source);
        }

        @Override
        public Itinerary[] newArray(int size) {
            return new Itinerary[size];
        }
    };
}
