package com.example.ashish14060.coxandkingsdemo.web_model;

/**
 * Created by Ashish14060 on 6/13/2018.
 */

public class RegisterUser
{
    private String Email;
    private String Password;
    private String ConfirmPassword;

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getConfirmPassword() {
        return ConfirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        ConfirmPassword = confirmPassword;
    }
}
