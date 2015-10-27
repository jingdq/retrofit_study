package com.jing.retrofit.services;

import com.jing.retrofit.model.Contributor;

import java.util.List;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by jimi on 10/27/15.
 */
public interface GithubClient {

    @GET("/repos/{owner}/{repo}/contributors")
    Call<List<Contributor>> contributors(@Path("owner")String owner,@Path("repo")String repo);




}
