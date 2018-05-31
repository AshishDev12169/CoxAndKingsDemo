package com.example.ashish14060.coxandkingsdemo.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.ashish14060.coxandkingsdemo.R;
import com.example.ashish14060.coxandkingsdemo.binding_model.MainActivityVM;
import com.example.ashish14060.coxandkingsdemo.databinding.ActivityMain1Binding;
import com.example.ashish14060.coxandkingsdemo.databinding.ActivityMain3Binding;
import com.example.ashish14060.coxandkingsdemo.manager.ModelConverter;
import com.example.ashish14060.coxandkingsdemo.model.FeaturePropertyFileModel;
import com.example.ashish14060.coxandkingsdemo.model.MainActivityFeatureModel;
import com.example.ashish14060.coxandkingsdemo.util.AssetFolderReader;

/**
 * Created by Ashish14060 on 5/31/2018.
 */

public class MainActivity3 extends AppCompatActivity
{
    ActivityMain3Binding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main3);

        FeaturePropertyFileModel data = AssetFolderReader.readFile(this);
        MainActivityFeatureModel mainActivityFeatureModel = data.getMainScreen();

        MainActivityVM mainActivityVM = ModelConverter.prepareMainActivityViewModelViewModel(mainActivityFeatureModel);
        activityMainBinding.setViewModel(mainActivityVM);
    }
}
