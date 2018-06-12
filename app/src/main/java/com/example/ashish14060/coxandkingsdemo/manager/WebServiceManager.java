package com.example.ashish14060.coxandkingsdemo.manager;

import android.util.Log;

import com.example.ashish14060.coxandkingsdemo.activity.WebApiListener;
import com.example.ashish14060.coxandkingsdemo.http.WebApiInterface;
import com.example.ashish14060.coxandkingsdemo.web_model.GetTripResponse;
import com.example.ashish14060.coxandkingsdemo.web_model.Trip;

import java.util.List;

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
    static WebApiInterface webApiInterface = null;
    private static WebApiInterface initialize()
    {
        if(webApiInterface == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://172.16.234.53:90/api/Trip/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            webApiInterface = retrofit.create(WebApiInterface.class);
        }

        return webApiInterface;
    }

    public static void getListOfUserTrip(final WebApiListener webApiInterface1)
    {
        WebApiInterface webAPIInterface = initialize();
        Call<GetTripResponse> call = webApiInterface.getUserList("10");
        call.enqueue(new Callback<GetTripResponse>() {

            @Override
            public void onResponse(Call<GetTripResponse> call, Response<GetTripResponse> response) {
                Log.d("dd", "Ashih");
                //GetTripResponse getTripResponse = response.body();

                webApiInterface1.onSuccess(response);
            }

            @Override
            public void onFailure(Call<GetTripResponse> call, Throwable throwable) {
                Log.d("dd", "Ashih");

                webApiInterface1.onFail(throwable);
            }
        });
    }


}
