package com.example.ashish14060.coxandkingsdemo.activity;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ashish14060.coxandkingsdemo.binding_model.MainActivityVM;
import com.example.ashish14060.coxandkingsdemo.databinding.ActivityMain1Binding;
import com.example.ashish14060.coxandkingsdemo.manager.ModelConverter;
import com.example.ashish14060.coxandkingsdemo.model.MainActivityFeatureModel;
import com.example.ashish14060.coxandkingsdemo.util.AssetFolderReader;
import com.example.ashish14060.coxandkingsdemo.util.Logger;
import com.example.ashish14060.coxandkingsdemo.R;
import com.example.ashish14060.coxandkingsdemo.model.FeaturePropertyFileModel;

public class MainActivity1 extends AppCompatActivity {

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
    }
}
