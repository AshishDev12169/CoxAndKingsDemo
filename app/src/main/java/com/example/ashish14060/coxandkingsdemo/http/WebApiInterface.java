package com.example.ashish14060.coxandkingsdemo.http;

import com.example.ashish14060.coxandkingsdemo.web_model.GetTripResponse;
import com.example.ashish14060.coxandkingsdemo.web_model.Trip;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Ashish14060 on 6/11/2018.
 */

public interface WebApiInterface
{
    @GET("GetTrip/{tripId}")
    Call<GetTripResponse> getUserList(@Path("tripId") String tripId);
}
