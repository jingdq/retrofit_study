package com.jing.retrofit.services;

import com.jing.retrofit.model.User;

import retrofit.http.POST;

/**
 * Created by jimi on 10/27/15.
 */
public interface LoginService {
    @POST("/login")
    User basicLogin();

}
