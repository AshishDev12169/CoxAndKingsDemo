package com.example.ashish14060.coxandkingsdemo.util;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

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
}
//    public static String getString(Context context, int resId)
//    {
//        context.getString()
//    }
//}
