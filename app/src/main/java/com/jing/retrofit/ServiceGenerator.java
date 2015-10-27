package com.jing.retrofit;

import com.squareup.okhttp.OkHttpClient;

import retrofit.Retrofit;
import retrofit.GsonConverterFactory;
/**
 * Created by jimi on 10/27/15.
 */
public class ServiceGenerator {

//    public static final String  API_BASE_URL ="http://api-base.url";
    public static final String  API_BASE_URL ="https://developer.github.com/v3/";

    private static OkHttpClient httpClient = new OkHttpClient();
    private static Retrofit.Builder builder = new Retrofit.Builder().baseUrl(API_BASE_URL).addConverterFactory(GsonConverterFactory.create());



   public static <S> S createService(Class<S> serviceClass){

       Retrofit retrofit = builder.client(httpClient).build();
      return retrofit.create(serviceClass);

   }




}
