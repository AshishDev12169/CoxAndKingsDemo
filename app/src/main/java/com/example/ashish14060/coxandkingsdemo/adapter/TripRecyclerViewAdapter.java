package com.example.ashish14060.coxandkingsdemo.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ashish14060.coxandkingsdemo.R;
import com.example.ashish14060.coxandkingsdemo.activity.ItineraryActivity;
import com.example.ashish14060.coxandkingsdemo.manager.HttpManager;
import com.example.ashish14060.coxandkingsdemo.manager.WebServiceManager;
import com.example.ashish14060.coxandkingsdemo.util.Constants;
import com.example.ashish14060.coxandkingsdemo.web_model.Itinerary;
import com.example.ashish14060.coxandkingsdemo.web_model.Trip;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Ashish14060 on 5/29/2018.
 */

public class TripRecyclerViewAdapter extends RecyclerView.Adapter<TripRecyclerViewAdapter.CustomViewHolder>
{
    private Context activityContext;
    private List<Trip> listOfTrip;
    private ClickListener clickListener;

    public TripRecyclerViewAdapter(Context activityContext, List<Trip> listOfTrip)
    {
        this.activityContext = activityContext;
        this.listOfTrip = listOfTrip;
        this.clickListener = new ClickListener();
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.trip_recycler_view_item, parent, false);

        itemView.setOnClickListener(clickListener);
        return new CustomViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position)
    {
        Trip trip = listOfTrip.get(position);
        holder.tvValueTripTo.setText(trip.getName());
        String tripStartDateAndEndDate = trip.getStartDate() +" to "+trip.getEndDate();
        holder.tvTripStartAndEndDate.setText(tripStartDateAndEndDate);

        holder.view.setTag(trip);
    }

    @Override
    public int getItemCount() {
        return listOfTrip.size();
    }


    public class CustomViewHolder extends RecyclerView.ViewHolder
    {
        public View view;
        public TextView tvValueTripTo, tvTripStartAndEndDate;

        public CustomViewHolder(View view) {
            super(view);
            this.view = view;
            tvValueTripTo = (TextView) view.findViewById(R.id.txtViewTripToValue);
            tvTripStartAndEndDate = (TextView) view.findViewById(R.id.tvTripStartAndEndDate);
        }

        public View getRootView()
        {
            return view;
        }
    }

    private class ClickListener implements View.OnClickListener
    {
        @Override
        public void onClick(View v)
        {
//          HttpManager.connect();
//
//          WebServiceManager.getListOfUserTrip();
            Trip tag = (Trip) v.getTag();
            ArrayList<Itinerary> listOfItinerary= tag.getListOfItinerary();
            Intent intent = new Intent(activityContext, ItineraryActivity.class);
            intent.putParcelableArrayListExtra(Constants.INTENT_DATA_KEY, listOfItinerary);
            activityContext.startActivity(intent);
        }
    }
}