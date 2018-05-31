package com.example.ashish14060.coxandkingsdemo.manager;

import com.example.ashish14060.coxandkingsdemo.binding_model.MainActivityVM;
import com.example.ashish14060.coxandkingsdemo.model.MainActivityFeatureModel;

/**
 * Created by Ashish14060 on 5/31/2018.
 */

public class ModelConverter
{
    public static MainActivityVM prepareMainActivityViewModelViewModel(MainActivityFeatureModel mainActivityFeatureModel)
    {
        MainActivityVM mainActivityVM = new MainActivityVM();

        mainActivityVM.setFlightBookingStatus(mainActivityFeatureModel.getFlightBookingStatus());
        mainActivityVM.setFlightStatus(mainActivityFeatureModel.getFlightStatus());
        mainActivityVM.setItinerary(mainActivityFeatureModel.getItinerary());
        mainActivityVM.setHotelBookingStatus(mainActivityFeatureModel.getHotelBookingStatus());
        mainActivityVM.setEmergencyContact(mainActivityFeatureModel.getEmergencyContact());

        return mainActivityVM;
    }
}
