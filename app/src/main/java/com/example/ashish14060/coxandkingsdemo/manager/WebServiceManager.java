package com.example.ashish14060.coxandkingsdemo.manager;

import android.util.Log;

import com.example.ashish14060.coxandkingsdemo.activity.WebApiListener;
import com.example.ashish14060.coxandkingsdemo.http.WebApiInterface;
import com.example.ashish14060.coxandkingsdemo.util.Constants;
import com.example.ashish14060.coxandkingsdemo.web_model.GetTripResponse;
import com.example.ashish14060.coxandkingsdemo.web_model.LoginUser;
import com.example.ashish14060.coxandkingsdemo.web_model.RegisterUser;
import com.example.ashish14060.coxandkingsdemo.web_model.RegisterUserResponse;
import com.example.ashish14060.coxandkingsdemo.web_model.ResponseData;

import java.util.logging.Level;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Ashish14060 on 6/11/2018.
 */

public class WebServiceManager
{
    private static WebApiInterface webApiInterface = null;
    private static WebApiInterface getWebApiInterface()
    {
        if(webApiInterface == null)
        {
           HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
           interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
           OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor). build();

           Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();



            webApiInterface = retrofit.create(WebApiInterface.class);
        }

        return webApiInterface;
    }

    public static void getListOfUserTrip(final WebApiListener webApiListener)
    {
        WebApiInterface webAPIInterface = getWebApiInterface();
        Call<GetTripResponse> call = webAPIInterface.getUserList("10");
        call.enqueue(new Callback<GetTripResponse>() {

            @Override
            public void onResponse(Call<GetTripResponse> call, Response<GetTripResponse> response) {
                webApiListener.onSuccess(response);
            }

            @Override
            public void onFailure(Call<GetTripResponse> call, Throwable throwable) {
                webApiListener.onFail(throwable);
            }
        });
    }

    public static void registerUser(RegisterUser registerUser, final WebApiListener webApiListener)
    {
        WebApiInterface webAPIInterface = getWebApiInterface();
        Call<RegisterUserResponse> call = webAPIInterface.registerUser(registerUser);
        call.enqueue(new Callback<RegisterUserResponse>() {

            @Override
            public void onResponse(Call<RegisterUserResponse> call, Response<RegisterUserResponse> response) {
                webApiListener.onSuccess(response);
            }

            @Override
            public void onFailure(Call<RegisterUserResponse> call, Throwable throwable) {
                webApiListener.onFail(throwable);
            }
        });
    }

    public static void loginUser(LoginUser loginUser, final WebApiListener webApiListener)
        {
        WebApiInterface webAPIInterface = getWebApiInterface();
        Call<Void> call = webAPIInterface.loginUser(loginUser.getUsername(), loginUser.getPassword(),loginUser.getGrant_type());
        call.enqueue(new Callback<Void>() {

            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                webApiListener.onSuccess(response);
            }

            @Override
            public void onFailure(Call<Void> call, Throwable throwable) {
                webApiListener.onFail(throwable);
            }
        });
    }





}
