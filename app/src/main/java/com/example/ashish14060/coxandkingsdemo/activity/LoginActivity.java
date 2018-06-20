package com.example.ashish14060.coxandkingsdemo.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.example.ashish14060.coxandkingsdemo.R;
import com.example.ashish14060.coxandkingsdemo.databinding.ActivityLoginBinding;
import com.example.ashish14060.coxandkingsdemo.manager.HttpManager;
import com.example.ashish14060.coxandkingsdemo.manager.SharePreferenceManager;
import com.example.ashish14060.coxandkingsdemo.manager.ValidationManager;
import com.example.ashish14060.coxandkingsdemo.manager.WebServiceManager;
import com.example.ashish14060.coxandkingsdemo.util.Util;
import com.example.ashish14060.coxandkingsdemo.web_model.ErrorModel;
import com.example.ashish14060.coxandkingsdemo.web_model.LoginErrorModal;
import com.example.ashish14060.coxandkingsdemo.web_model.LoginUser;
import com.example.ashish14060.coxandkingsdemo.web_model.RegisterUser;
import com.google.gson.Gson;

import retrofit2.Response;

/**
 * Created by Ashish14060 on 6/13/2018.
 */

public class LoginActivity extends BaseActivity implements View.OnClickListener, WebApiListener
{
    private ActivityLoginBinding dataBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);

        initializeView();
    }

    private void initializeView()
    {
        dataBinding.buttonLogin.setOnClickListener(this);
    }


    @Override
    public void onClick(View view)
    {
        String emailId = dataBinding.editTextEmail.getText().toString();
        String password = dataBinding.editTextPassword.getText().toString();


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

        if(!hasEmptyError)
        {
            LoginUser loginUser = new LoginUser();
            loginUser.setUsername(emailId);
            loginUser.setPassword(password);
            loginUser.setGrant_type("password");

            // Call Login Api
            callLoginUserApi(loginUser);
        }

    }

    ProgressDialog progressDialog;
    private void callLoginUserApi(LoginUser loginUser)
    {
        progressDialog = Util.showProgressDialog(this);
        WebServiceManager.loginUser(loginUser, this);
    }


    @Override
    public void onSuccess(Response response)
    {
        Util.dismissDialog(progressDialog);
        if(response.isSuccessful())
        {
            SharePreferenceManager.setUserLoginSuccessful(this);
            Intent intent = new Intent(this, MainActivity1.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();

            Toast.makeText(this, "Login Successfully", Toast.LENGTH_LONG).show();
        }
        else
        {
            String message = null;
            try
            {
                message = Util.convertStreamToString(response);
                Gson gson = new Gson();
                LoginErrorModal errorModel = gson.fromJson(message, LoginErrorModal.class);
//              String[] modelState = errorModel.getModelState();
                if(errorModel != null)
                {
                    Toast.makeText(this, errorModel.getError_description(), Toast.LENGTH_LONG).show();
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
