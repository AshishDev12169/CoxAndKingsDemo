package com.example.ashish14060.coxandkingsdemo.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;

import com.example.ashish14060.coxandkingsdemo.R;
import com.example.ashish14060.coxandkingsdemo.adapter.ItineraryRecyclerViewAdapter;
import com.example.ashish14060.coxandkingsdemo.databinding.ItineraryLayoutBinding;
import com.example.ashish14060.coxandkingsdemo.util.Util;
import com.example.ashish14060.coxandkingsdemo.web_model.Itinerary;

import java.util.ArrayList;

/**
 * Created by Ashish14060 on 6/6/2018.
 */

public class ItineraryActivity extends BaseActivity
{
    private ItineraryLayoutBinding itineraryLayoutBinding;
    private ArrayList<Itinerary> listOfItinerary;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        itineraryLayoutBinding = DataBindingUtil.setContentView(this, R.layout.itinerary_layout);

        initializeView();
    }

    private void initializeView()
    {
        listOfItinerary = (ArrayList<Itinerary>) Util.getIntentData(getIntent());

        ItineraryRecyclerViewAdapter viewAdapter = new ItineraryRecyclerViewAdapter(this, listOfItinerary);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        itineraryLayoutBinding.recyclerViewItinerary.setLayoutManager(linearLayoutManager);
        itineraryLayoutBinding.recyclerViewItinerary.setAdapter(viewAdapter);
    }
}
