package com.example.ashish14060.coxandkingsdemo.util;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Ashish14060 on 6/6/2018.
 */

public class Util {
    public static Object getIntentData(Intent intent) {
        Object object = null;
        if (intent != null) {
            Bundle bundle = intent.getExtras();
            if (bundle.containsKey(Constants.INTENT_DATA_KEY)) {
                object = bundle.get(Constants.INTENT_DATA_KEY);
            }
        }

        return object;
    }

    public static String formatTime(String format)
    {
        String response = null;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            Date date = simpleDateFormat.parse(format);

            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd-MM-yyyy");
            response = simpleDateFormat2.format(date);
        }
        catch (Exception exception)
        {

        }
        return response;
    }

}
//    public static String getString(Context context, int resId)
//    {
//        context.getString()
//    }
//}
