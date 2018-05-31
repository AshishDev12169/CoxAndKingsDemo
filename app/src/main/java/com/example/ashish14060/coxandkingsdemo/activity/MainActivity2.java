package com.example.ashish14060.coxandkingsdemo.activity;


import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.ashish14060.coxandkingsdemo.R;
import com.example.ashish14060.coxandkingsdemo.adapter.Adapter;
import com.example.ashish14060.coxandkingsdemo.binding_model.MainActivityUiModel;
import com.example.ashish14060.coxandkingsdemo.binding_model.MainActivityVM;
import com.example.ashish14060.coxandkingsdemo.manager.ModelConverter;
import com.example.ashish14060.coxandkingsdemo.model.MainActivityFeatureModel;
import com.example.ashish14060.coxandkingsdemo.util.AssetFolderReader;

import java.util.ArrayList;

/**
 * Created by Ashish14060 on 5/30/2018.
 */

public class MainActivity2 extends MainActivity1
{
    private String[] arrayOfFeatureName = {"flightStatus","itinerary","hotelBookingStatus","flightBookingStatus","emergencyContact"};
    private int[] arrayOfFeatureIcons = {R.drawable.flight_status_icon, R.drawable.flight_status_icon,
                          R.drawable.flight_status_icon,
                          R.drawable.flight_status_icon,R.drawable.flight_status_icon};

    private ArrayList<MainActivityUiModel> listOfMainActivityFeatures = new ArrayList<>();


    MainActivityVM mainActivityVM;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        initializeView();
    }

    private void initializeView()
    {
        MainActivityFeatureModel mainActivityFeatureModel = AssetFolderReader.readFile(this).getMainScreen();
        mainActivityVM = ModelConverter.prepareMainActivityViewModelViewModel(mainActivityFeatureModel);

        prepareRecyclerViewAdapterModel();

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(gridLayoutManager);
        Adapter adapter = new Adapter(listOfMainActivityFeatures);
        recyclerView.setAdapter(adapter);


        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new ItemDecorationAlbumColumns(20,2));
    }

    private void prepareRecyclerViewAdapterModel()
    {
        for(int i = 0; i< arrayOfFeatureName.length; i++)
        {

            boolean isToAdd = false;

            if(arrayOfFeatureName[i].equalsIgnoreCase("flightStatus") && mainActivityVM.getFlightStatus())
            {
                isToAdd = true;
            }
            else if(arrayOfFeatureName[i].equalsIgnoreCase("itinerary") && mainActivityVM.getItinerary())
            {
                isToAdd = true;
            }
            else if(arrayOfFeatureName[i].equalsIgnoreCase("hotelBookingStatus") && mainActivityVM.getHotelBookingStatus())
            {
                isToAdd = true;
            }
            else if(arrayOfFeatureName[i].equalsIgnoreCase("flightBookingStatus") && mainActivityVM.getFlightBookingStatus())
            {
                isToAdd = true;
            }
            else if(arrayOfFeatureName[i].equalsIgnoreCase("emergencyContact") && mainActivityVM.getEmergencyContact())
            {
                isToAdd = true;
            }

            if(isToAdd)
            {
                MainActivityUiModel mainActivityData = new MainActivityUiModel();
                mainActivityData.setIcon(arrayOfFeatureIcons[i]);
                mainActivityData.setFeatureName(arrayOfFeatureName[i]);
                listOfMainActivityFeatures.add(mainActivityData);
            }
        }
    }

    public class ItemDecorationAlbumColumns extends RecyclerView.ItemDecoration {

        private int mSizeGridSpacingPx;
        private int mGridSize;

        private boolean mNeedLeftSpacing = false;

        public ItemDecorationAlbumColumns(int gridSpacingPx, int gridSize) {
            mSizeGridSpacingPx = gridSpacingPx;
            mGridSize = gridSize;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int frameWidth = (int) ((parent.getWidth() - (float) mSizeGridSpacingPx * (mGridSize - 1)) / mGridSize);
            int padding = parent.getWidth() / mGridSize - frameWidth;
            int itemPosition = ((RecyclerView.LayoutParams) view.getLayoutParams()).getViewAdapterPosition();
            if (itemPosition < mGridSize) {
                outRect.top = 0;
            } else {
                outRect.top = mSizeGridSpacingPx;
            }
            if (itemPosition % mGridSize == 0) {
                outRect.left = 0;
                outRect.right = padding;
                mNeedLeftSpacing = true;
            } else if ((itemPosition + 1) % mGridSize == 0) {
                mNeedLeftSpacing = false;
                outRect.right = 0;
                outRect.left = padding;
            } else if (mNeedLeftSpacing) {
                mNeedLeftSpacing = false;
                outRect.left = mSizeGridSpacingPx - padding;
                if ((itemPosition + 2) % mGridSize == 0) {
                    outRect.right = mSizeGridSpacingPx - padding;
                } else {
                    outRect.right = mSizeGridSpacingPx / 2;
                }
            } else if ((itemPosition + 2) % mGridSize == 0) {
                mNeedLeftSpacing = false;
                outRect.left = mSizeGridSpacingPx / 2;
                outRect.right = mSizeGridSpacingPx - padding;
            } else {
                mNeedLeftSpacing = false;
                outRect.left = mSizeGridSpacingPx / 2;
                outRect.right = mSizeGridSpacingPx / 2;
            }
            outRect.bottom = 0;
        }
    }
}
