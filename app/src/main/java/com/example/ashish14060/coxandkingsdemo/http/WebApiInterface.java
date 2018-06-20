package com.example.ashish14060.coxandkingsdemo.http;

import com.example.ashish14060.coxandkingsdemo.web_model.GetTripResponse;
import com.example.ashish14060.coxandkingsdemo.web_model.LoginUser;
import com.example.ashish14060.coxandkingsdemo.web_model.RegisterUser;
import com.example.ashish14060.coxandkingsdemo.web_model.RegisterUserResponse;
import com.example.ashish14060.coxandkingsdemo.web_model.ResponseData;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Ashish14060 on 6/11/2018.
 */

public interface WebApiInterface
{
    @GET("Trip/GetTrip/{tripId}")
    Call<GetTripResponse> getUserList(@Path("tripId") String tripId);

    @POST("api/Account/Register")
    Call<RegisterUserResponse> registerUser(@Body RegisterUser registerUser);

    @POST("token")
    @FormUrlEncoded
    @Headers("Content-Type:application/x-www-form-urlencoded")
    Call<Void> loginUser(@Field("username") String username, @Field("password") String password, @Field("grant_type") String grant_type);
}
