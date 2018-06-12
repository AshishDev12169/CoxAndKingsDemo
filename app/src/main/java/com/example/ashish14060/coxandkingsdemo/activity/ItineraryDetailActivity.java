package com.example.ashish14060.coxandkingsdemo.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.ashish14060.coxandkingsdemo.R;

/**
 * Created by Ashish14060 on 6/11/2018.
 */

public class ItineraryDetailActivity extends BaseActivity
{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.itinerary_detail_layout);

        setTitle("Flight Status");
    }
}
