package com.example.ashish14060.coxandkingsdemo.util;

import android.content.Context;
import android.content.res.AssetManager;

import com.example.ashish14060.coxandkingsdemo.model.FeaturePropertyFileModel;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;

/**
 * Created by Ashish14060 on 5/30/2018.
 */

public class AssetFolderReader
{
    public static FeaturePropertyFileModel readFile(Context context)
    {
        FeaturePropertyFileModel propertyModel = null;
        String fileData = null;
        AssetManager mgr = context.getAssets();
        String filename = "on_off_property_file";

        try {

            System.out.println("filename : " + filename);
            InputStream in = mgr.open(filename);
            fileData = StreamToString(in);
            in.close();

            Gson gson = new Gson();
            propertyModel = gson.fromJson(fileData, FeaturePropertyFileModel.class);

        }
        catch (IOException e) {

            e.printStackTrace();
        }

        return propertyModel;
    }


    public static String StreamToString(InputStream in) throws IOException {

        if(in == null)
        {
            return "";
        }

        Writer writer = new StringWriter();
        char[] buffer = new char[1024];
        try
        {
            Reader reader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
            int n;
            while ((n = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, n);
            }
        }
        finally
        {
        }

        return writer.toString();
    }
}
