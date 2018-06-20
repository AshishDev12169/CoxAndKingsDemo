package com.example.ashish14060.coxandkingsdemo.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.ashish14060.coxandkingsdemo.R;
import com.example.ashish14060.coxandkingsdemo.databinding.ActivityLoginRegisterBinding;
import com.example.ashish14060.coxandkingsdemo.manager.SharePreferenceManager;

/**
 * Created by Ashish14060 on 6/12/2018.
 */

public class LoginRegisterActivity extends BaseActivity implements View.OnClickListener
{
    private ActivityLoginRegisterBinding dataBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(SharePreferenceManager.isUserLoginSuccessfully(this))
        {
            finish();
            Intent intent = new Intent(this, MainActivity1.class);
            startActivity(intent);
        }
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_login_register);
        initializeView();
    }

    private void initializeView()
    {
        dataBinding.buttonLogin.setOnClickListener(this);
        dataBinding.buttonRegister.setOnClickListener(this);
    }


    @Override
    public void onClick(View view)
    {
        int viewId = view.getId();
        switch (viewId)
        {
            case R.id.buttonLogin:
                onClick_ButtonLogin();
                break;

            case R.id.buttonRegister:
                onClick_ButtonRegister();
                break;
        }
    }

    private void onClick_ButtonLogin()
    {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    private void onClick_ButtonRegister()
    {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }
}
