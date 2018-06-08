package com.example.ashish14060.coxandkingsdemo.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.ashish14060.coxandkingsdemo.R;
import com.example.ashish14060.coxandkingsdemo.binding_model.MainActivityVM;
import com.example.ashish14060.coxandkingsdemo.databinding.ActivityMain1Binding;
import com.example.ashish14060.coxandkingsdemo.manager.ModelConverter;
import com.example.ashish14060.coxandkingsdemo.model.MainActivityFeatureModel;
import com.example.ashish14060.coxandkingsdemo.util.AssetFolderReader;
import com.example.ashish14060.coxandkingsdemo.model.FeaturePropertyFileModel;

public class MainActivity1 extends AppCompatActivity implements View.OnClickListener
{

    ActivityMain1Binding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main1);

        FeaturePropertyFileModel data = AssetFolderReader.readFile(this);
        MainActivityFeatureModel mainActivityFeatureModel = data.getMainScreen();

        MainActivityVM mainActivityVM = ModelConverter.prepareMainActivityViewModelViewModel(mainActivityFeatureModel);
        activityMainBinding.setViewModel(mainActivityVM);

        activityMainBinding.layoutUserItinerary.setOnClickListener(this);
    }


    @Override
    public void onClick(View view)
    {
        int viewId = view.getId();
        switch (viewId)
        {
            case R.id.layoutUserItinerary:
                onClick_LayoutUserItinerary();
                break;

        }
    }

    private void onClick_LayoutUserItinerary()
    {
        Intent intent = new Intent(this, TripActivity.class);
        startActivity(intent);
    }
}
