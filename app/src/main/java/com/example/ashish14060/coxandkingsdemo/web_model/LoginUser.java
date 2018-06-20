package com.example.ashish14060.coxandkingsdemo.web_model;

/**
 * Created by Ashish14060 on 6/13/2018.
 */

public class LoginUser
{
    private String username;
    private String password;
    private String grant_type = "password";

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGrant_type() {
        return grant_type;
    }

    public void setGrant_type(String grant_type) {
        this.grant_type = grant_type;
    }
}
