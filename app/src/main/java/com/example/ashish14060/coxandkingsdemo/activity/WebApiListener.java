package com.example.ashish14060.coxandkingsdemo.activity;

import retrofit2.Response;

/**
 * Created by Ashish14060 on 6/12/2018.
 */

public interface WebApiListener
{
    void onSuccess(Response response);
    void onFail(Throwable throwable);
}
