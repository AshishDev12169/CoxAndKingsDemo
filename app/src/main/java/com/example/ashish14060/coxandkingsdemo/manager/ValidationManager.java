package com.example.ashish14060.coxandkingsdemo.manager;

/**
 * Created by Ashish14060 on 6/12/2018.
 */

public class ValidationManager
{
    public static boolean isEmpty(String value)
    {
        boolean isEmpty = true;
        if(value != null && value.trim().length()> 0)
        {
            isEmpty = false;
        }

        return isEmpty;
    }

}
