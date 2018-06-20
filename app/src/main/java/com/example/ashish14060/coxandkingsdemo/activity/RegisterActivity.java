package com.example.ashish14060.coxandkingsdemo.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.example.ashish14060.coxandkingsdemo.R;
import com.example.ashish14060.coxandkingsdemo.databinding.ActivityRegisterBinding;
import com.example.ashish14060.coxandkingsdemo.manager.HttpManager;
import com.example.ashish14060.coxandkingsdemo.manager.ValidationManager;
import com.example.ashish14060.coxandkingsdemo.manager.WebServiceManager;
import com.example.ashish14060.coxandkingsdemo.util.Util;
import com.example.ashish14060.coxandkingsdemo.web_model.ErrorModel;
import com.example.ashish14060.coxandkingsdemo.web_model.RegisterUser;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;

import okhttp3.ResponseBody;
import retrofit2.Response;

/**
 * Created by Ashish14060 on 6/12/2018.
 */

public class RegisterActivity extends BaseActivity implements View.OnClickListener, WebApiListener
{
    private ActivityRegisterBinding dataBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_register);

        initializeView();
    }

    private void initializeView()
    {
        dataBinding.buttonRegister.setOnClickListener(this);
    }


    @Override
    public void onClick(View view)
    {
        onClick_ButtonSubmit();
    }

    private void onClick_ButtonSubmit()
    {
        String emailId = dataBinding.editTextEmail.getText().toString();
        String password = dataBinding.editTextPassword.getText().toString();
        String retypePassword = dataBinding.editTextReTypePassword.getText().toString();

        boolean hasEmptyError = false;
        if(ValidationManager.isEmpty(emailId))
        {
            dataBinding.editTextEmail.setError("!Email can not empty");
            hasEmptyError = true;
        }
        if(ValidationManager.isEmpty(password))
        {
            dataBinding.editTextEmail.setError("!Password can not empty");
            hasEmptyError = true;
        }
        if(ValidationManager.isEmpty(retypePassword))
        {
            dataBinding.editTextEmail.setError("!Retype Password can not empty");
            hasEmptyError = true;
        }

        if(!hasEmptyError)
        {
            if(!password.equals(retypePassword))
            {
                Toast.makeText(this, "!Password and Retype Password are not equal", Toast.LENGTH_SHORT).show();
            }
            else
            {
                RegisterUser registerUser = new RegisterUser();
                registerUser.setEmail(emailId);
                registerUser.setPassword(password);
                registerUser.setConfirmPassword(retypePassword);

                // Call Register Api
                callRegisterUserApi(registerUser);
            }
        }
    }

    ProgressDialog progressDialog;
    private void callRegisterUserApi(RegisterUser registerUser)
    {
        progressDialog  = Util.showProgressDialog(this);
        WebServiceManager.registerUser(registerUser, this);
    }

    @Override
    public void onSuccess(Response response)
    {
        Util.dismissDialog(progressDialog);
        if(response.isSuccessful())
        {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            finish();

            Toast.makeText(this, "User Register Successfully", Toast.LENGTH_LONG).show();
        }
        else
        {
            String message = null;
            try
            {
                message = Util.convertStreamToString(response);
                Gson gson = new Gson();
                ErrorModel errorModel = gson.fromJson(message, ErrorModel.class);
//              String[] modelState = errorModel.getModelState();
                if(errorModel != null)
                {
                    Toast.makeText(this, errorModel.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
            catch (Exception e)
            {
                Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
            }
        }
    }



    @Override
    public void onFail(Throwable throwable) {
        Util.dismissDialog(progressDialog);
        handleException(throwable);
    }


}
