package com.example.ashish14060.coxandkingsdemo.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ashish14060.coxandkingsdemo.R;
import com.example.ashish14060.coxandkingsdemo.activity.ItineraryDetailActivity;
import com.example.ashish14060.coxandkingsdemo.util.Constants;
import com.example.ashish14060.coxandkingsdemo.util.Util;
import com.example.ashish14060.coxandkingsdemo.web_model.Itinerary;

import java.util.List;


/**
 * Created by Ashish14060 on 5/29/2018.
 */

public class ItineraryRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
    private Context activityContext;
    private List<Itinerary> listOfItinerary;
    private ClickListener clickListener;

    public ItineraryRecyclerViewAdapter(Context activityContext, List<Itinerary> listOfItinerary)
    {
        this.activityContext = activityContext;
        this.listOfItinerary = listOfItinerary;
        this.clickListener = new ClickListener();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        RecyclerView.ViewHolder viewHolder = null;
        if(viewType == Constants.ITINERARY_VIEW_TRAVEL)
        {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.itinerary_recycler_view_item_travel, parent, false);
            itemView.setOnClickListener(clickListener);
            viewHolder = new TravelingViewHolder(itemView);

        }
        else if(viewType == Constants.ITINERARY_VIEW_HOTEL)
        {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.itinerary_recycler_view_item_hotel, parent, false);
            itemView.setOnClickListener(clickListener);
            viewHolder = new HotelViewHolder(itemView);
        }

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        Itinerary itinerary = listOfItinerary.get(position);

        holder.itemView.setTag(itinerary);

        if(holder.getItemViewType() ==  Constants.ITINERARY_VIEW_TRAVEL )
        {
            TravelingViewHolder customViewHolder = (TravelingViewHolder) holder;
            customViewHolder.txtViewProvider.setText(itinerary.getType() +" : "+itinerary.getProvider());
            customViewHolder.textViewDate.setText(activityContext.getString(R.string.itinerary_date)+": "+ Util.prepareAppDateFormat(itinerary.getDate()));
            customViewHolder.txtViewSourcePointCode.setText(itinerary.getSourceAirportCode());
            customViewHolder.txtViewSourcePointName.setText(itinerary.getSource());
            customViewHolder.txtViewDestinationPointCode.setText(itinerary.getDestinationAirportCode());
            customViewHolder.txtViewDestinationPointName.setText(itinerary.getDestination());

            int itineraryTypeId = itinerary.getTypeId();
            switch(itineraryTypeId)
            {
                case Constants.ITINERARY_TYPE_FLIGHT:
                    customViewHolder.textViewFlightNumber.setVisibility(View.GONE);
                    customViewHolder.imageViewTypeIcon.setImageResource(R.drawable.icon_flight);
                    break;
                case Constants.ITINERARY_TYPE_TRAIN:
                    customViewHolder.textViewFlightNumber.setVisibility(View.VISIBLE);
                    customViewHolder.textViewFlightNumber.setText("PNR: "+itinerary.getPnrNumber());
                    customViewHolder.imageViewTypeIcon.setImageResource(R.drawable.icon_train);
                    break;
                case Constants.ITINERARY_TYPE_HELICOPTER:
                    customViewHolder.textViewFlightNumber.setVisibility(View.GONE);
                    customViewHolder.imageViewTypeIcon.setImageResource(R.drawable.icon_helicopter);
                    break;
                case Constants.ITINERARY_TYPE_CAB:
                    customViewHolder.textViewFlightNumber.setVisibility(View.GONE);
                    customViewHolder.imageViewTypeIcon.setImageResource(R.drawable.icon_cab);
                    break;
            }
        }
        else if(holder.getItemViewType() ==  Constants.ITINERARY_VIEW_HOTEL)
        {
            HotelViewHolder customViewHolder = (HotelViewHolder) holder;
            customViewHolder.txtViewHotelName.setText("Hotel: "+itinerary.getHotelName());
            customViewHolder.txtViewCheckInValue.setText(Util.prepareAppDateFormat(itinerary.getCheckInDate()));
            customViewHolder.txtViewCheckOutValue.setText(Util.prepareAppDateFormat(itinerary.getCheckOutDate()));

            customViewHolder.txtViewPersonName.setText(itinerary.getContactPersonName());
            customViewHolder.txtViewPersonNumber.setText(itinerary.getContactPersonPhoneNumber());
            customViewHolder.txtViewAddress.setText("Address: "+itinerary.getAddress());
        }

    }

    @Override
    public int getItemViewType(int position)
    {
          int viewType = 0;
          Itinerary itinerary = getItinerary(position);
          switch(itinerary.getTypeId())
          {
              case Constants.ITINERARY_TYPE_FLIGHT:
              case Constants.ITINERARY_TYPE_TRAIN:
              case Constants.ITINERARY_TYPE_HELICOPTER:
              case Constants.ITINERARY_TYPE_CAB:
                  viewType = Constants.ITINERARY_VIEW_TRAVEL;
                  break;
              case Constants.ITINERARY_TYPE_HOTEL:
                  viewType = Constants.ITINERARY_VIEW_HOTEL;
                  break;
          }

          return viewType;
    }

    private Itinerary getItinerary(int position)
    {
        Itinerary itinerary = listOfItinerary.get(position);
        return itinerary;
    }

    @Override
    public int getItemCount() {
        return listOfItinerary.size();
    }


    public class TravelingViewHolder extends RecyclerView.ViewHolder
    {
        View view;
        TextView txtViewProvider;
        TextView textViewFlightNumber;
        TextView textViewDate;
        TextView txtViewSourcePointCode;
        TextView txtViewSourcePointName;
        TextView txtViewDestinationPointCode;
        TextView txtViewDestinationPointName;
        ImageView imageViewTypeIcon;



        public TravelingViewHolder(View view) {
            super(view);
            this.view = view;
            imageViewTypeIcon = (ImageView) view.findViewById(R.id.imageViewTypeIcon);
            txtViewProvider = (TextView) view.findViewById(R.id.txtViewProvider);
            textViewFlightNumber = (TextView) view.findViewById(R.id.textViewFlightNumber);
            textViewDate = (TextView) view.findViewById(R.id.textViewDate);
            txtViewSourcePointCode = (TextView) view.findViewById(R.id.txtViewSourcePointCode);
            txtViewSourcePointName = (TextView) view.findViewById(R.id.txtViewSourcePointName);
            txtViewDestinationPointCode = (TextView) view.findViewById(R.id.txtViewDestinationPointCode);
            txtViewDestinationPointName = (TextView) view.findViewById(R.id.txtViewDestinationPointName);
        }
    }

    public class HotelViewHolder extends RecyclerView.ViewHolder
    {
        public View view;
        public TextView txtViewHotelName, txtViewCheckInValue;
        public TextView txtViewCheckOutValue;
        public TextView txtViewPersonName;
        public TextView txtViewPersonNumber;
        public TextView txtViewAddress;

        public HotelViewHolder(View view) {
            super(view);
            this.view = view;
            txtViewHotelName = (TextView) view.findViewById(R.id.txtViewHotelName);
            txtViewCheckInValue = (TextView) view.findViewById(R.id.txtViewCheckInValue);
            txtViewCheckOutValue = (TextView) view.findViewById(R.id.txtViewCheckOutValue);
            txtViewPersonName = (TextView) view.findViewById(R.id.txtViewContactPersonName);
            txtViewPersonNumber = (TextView) view.findViewById(R.id.txtViewPersonNumber);
            txtViewAddress = (TextView) view.findViewById(R.id.txtViewAddress);
        }
    }


    private class ClickListener implements View.OnClickListener
    {
        @Override
        public void onClick(View v)
        {
            Itinerary itinerary = (Itinerary) v.getTag();
            int viewType = 0;
            switch(itinerary.getTypeId())
            {
                case Constants.ITINERARY_TYPE_FLIGHT:
                    Intent intent = new Intent(activityContext, ItineraryDetailActivity.class);
                    activityContext.startActivity(intent);
                    break;
                case Constants.ITINERARY_TYPE_TRAIN:
                case Constants.ITINERARY_TYPE_HELICOPTER:
                case Constants.ITINERARY_TYPE_CAB:

                    break;
                case Constants.ITINERARY_TYPE_HOTEL:
                    viewType = Constants.ITINERARY_VIEW_HOTEL;
                    break;
            }
        }
    }
}