package com.example.ashish14060.coxandkingsdemo.activity;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.ashish14060.coxandkingsdemo.R;
import com.example.ashish14060.coxandkingsdemo.adapter.TripRecyclerViewAdapter;
import com.example.ashish14060.coxandkingsdemo.databinding.TripLayoutBinding;
import com.example.ashish14060.coxandkingsdemo.manager.WebServiceManager;
import com.example.ashish14060.coxandkingsdemo.util.Constants;
import com.example.ashish14060.coxandkingsdemo.util.JsonParser;
import com.example.ashish14060.coxandkingsdemo.web_model.GetTripResponse;
import com.example.ashish14060.coxandkingsdemo.web_model.Trip;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Ashish14060 on 5/28/2018.
 */

public class TripActivity extends BaseActivity implements WebApiListener
{
    private TripLayoutBinding tripLayoutBinding;

    private ArrayList<Trip> listOfTrips = new ArrayList<>();
    private TripRecyclerViewAdapter tripRecyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        tripLayoutBinding = DataBindingUtil.setContentView(this, R.layout.trip_layout);

        initializeView();
        getUserTripInfo();
    }

    private void initializeView()
    {
        tripRecyclerViewAdapter = new TripRecyclerViewAdapter(this, listOfTrips);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        tripLayoutBinding.recyclerViewTrip.setLayoutManager(linearLayoutManager);
        tripLayoutBinding.recyclerViewTrip.setAdapter(tripRecyclerViewAdapter);
    }

    private void getUserTripInfo()
    {
        WebServiceManager.getListOfUserTrip(this);
//        GetTripResponse getTripResponse = (GetTripResponse) JsonParser.parse(Constants.USER_TRIP_INFORMATION);
//        List<Trip> listOfUserTrip = getTripResponse.getTrips();
//
//        updateTripRecyclerView(listOfUserTrip);
    }

    private void updateTripRecyclerView(List<Trip> listOfTrips)
    {
        if(listOfTrips != null)
        {
            this.listOfTrips.clear();
            this.listOfTrips.addAll(listOfTrips);
            tripRecyclerViewAdapter.notifyDataSetChanged();
        }
    }


    @Override
    public void onSuccess(Response response)
    {
        GetTripResponse getTripResponse = (GetTripResponse) response.body();
        List<Trip> listOfUserTrip = getTripResponse.getTrips();

        updateTripRecyclerView(listOfUserTrip);
    }

    @Override
    public void onFail(Throwable throwable) {
        handleException(throwable);
    }
}
