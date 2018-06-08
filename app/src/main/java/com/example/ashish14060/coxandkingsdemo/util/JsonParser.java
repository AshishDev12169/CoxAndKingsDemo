package com.example.ashish14060.coxandkingsdemo.util;


import com.example.ashish14060.coxandkingsdemo.web_model.GetTripResponse;
import com.example.ashish14060.coxandkingsdemo.web_model.MasterResponse;
import com.google.gson.Gson;

/**
 * Created by Ashish14060 on 5/28/2018.
 */

public class JsonParser
{
    public static MasterResponse parse(String jsonString)
    {
        Gson gson = new Gson();
        MasterResponse masterResponse =  gson.fromJson(jsonString, GetTripResponse.class);
        return masterResponse;
    }

}
