package com.example.ashish14060.coxandkingsdemo.manager;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Ashish14060 on 6/20/2018.
 */

public class SharePreferenceManager
{
    private static final String NAME = "CoxKing";
    public static void setUserLoginSuccessful(Context context)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences(NAME, context.MODE_PRIVATE);
        sharedPreferences.edit().putBoolean("isLogin", true).commit();
    }

    public static boolean isUserLoginSuccessfully(Context context)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences(NAME, context.MODE_PRIVATE);
        return sharedPreferences.getBoolean("isLogin", false);
    }
}
