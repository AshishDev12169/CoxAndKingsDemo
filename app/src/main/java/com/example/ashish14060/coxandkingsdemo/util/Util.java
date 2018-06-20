package com.example.ashish14060.coxandkingsdemo.util;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import okhttp3.ResponseBody;
import retrofit2.Response;

/**
 * Created by Ashish14060 on 6/6/2018.
 */

public class Util
{
    public static Object getIntentData(Intent intent)
    {
        Object data = null;
        if (intent != null)
        {
            Bundle bundle = intent.getExtras();

            if (bundle != null && bundle.containsKey(Constants.INTENT_DATA_KEY))
            {
                data = bundle.get(Constants.INTENT_DATA_KEY);
            }
        }

        return data;
    }

    public static String prepareAppDateFormat(String serverFormattedDate)
    {
        String responseString = null;
        try
        {
            SimpleDateFormat serverDateFormat = new SimpleDateFormat(Constants.DATE_FORMAT_SEVER);
            Date date = serverDateFormat.parse(serverFormattedDate);

            SimpleDateFormat appDateFormat = new SimpleDateFormat(Constants.DATE_FORMAT_dd_MM_yyyy);
            responseString = appDateFormat.format(date);
        }
        catch (Exception exception)
        {
            Logger.log("Exception: "+exception.toString());
        }

        return responseString;
    }


    public static String convertStreamToString(Response response) throws IOException
    {
        StringBuilder result = new StringBuilder();
        try
        {
            ResponseBody responseBody = response.errorBody();
            InputStream ins = responseBody.byteStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(ins));

            String line;
            while((line = reader.readLine()) != null)
            {
                result.append(line);
            }
        }
        catch (Exception exception)
        {
            throw exception;
        }

        return result.toString();
    }

    public static ProgressDialog showProgressDialog(Context context)
    {
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("!please wait");
        progressDialog.show();
        return progressDialog;
    }

    public static void dismissDialog(ProgressDialog progressDialog)
    {
        if(progressDialog != null)
        {
            if(progressDialog.isShowing())
            {
                progressDialog.dismiss();
            }
        }

    }



}
