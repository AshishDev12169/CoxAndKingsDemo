package com.example.ashish14060.coxandkingsdemo.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by Ashish14060 on 6/6/2018.
 */

public class BaseActivity extends AppCompatActivity
{
    protected void handleException(Throwable throwable)
    {
        String errorMessage = throwable.toString();
        Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show();
    }


}
