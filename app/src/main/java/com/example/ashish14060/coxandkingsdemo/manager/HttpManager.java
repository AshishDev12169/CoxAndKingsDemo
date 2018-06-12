package com.example.ashish14060.coxandkingsdemo.manager;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Ashish14060 on 6/8/2018.
 */

public class HttpManager
{
    public static void connect()
    {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    HttpURLConnection conn = (HttpURLConnection) (new URL("http://172.16.234.53:90/api/Trip/GetTrip/10"))
                            .openConnection();
                    conn.setUseCaches(false);
                    conn.connect();
                    int status = conn.getResponseCode();

                    BufferedReader reader = null;
                    StringBuffer response = new StringBuffer();
                    try {
                        reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                        String line = "";
                        while ((line = reader.readLine()) != null) {
                            response.append(line);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        if (reader != null) {
                            try {
                                reader.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }



                    conn.disconnect();

                } catch (Exception e) {
                    Log.e("doHttpGetRequest", e.toString());
                }
            }
        }).start();

    }
}
