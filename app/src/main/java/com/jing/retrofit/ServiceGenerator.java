package com.jing.retrofit;

import android.app.DownloadManager;
import android.util.Base64;

import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

import retrofit.Retrofit;
import retrofit.GsonConverterFactory;

/**
 * Created by jimi on 10/27/15.
 */
public class ServiceGenerator {

    //    public static final String  API_BASE_URL ="http://api-base.url";
    public static final String API_BASE_URL = "https://developer.github.com/v3/";

    private static OkHttpClient httpClient = new OkHttpClient();
    private static Retrofit.Builder builder = new Retrofit.Builder().baseUrl(API_BASE_URL).addConverterFactory(GsonConverterFactory.create());


    public static <S> S createService(Class<S> serviceClass) {

        return createService(serviceClass, null, null);

    }


    public static <S> S createService(Class<S> serviceClass, String username, String password) {

        if (username != null && password != null) {
            String credentials = username + ":" + password;
            final String basic =
                    "Basic " + Base64.encodeToString(credentials.getBytes(), Base64.NO_WRAP);
            httpClient.interceptors().add(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request original = chain.request();

                    Request.Builder requestBuilder = original.newBuilder()
                            .header("Authorization", basic)
                            .header("Accept", "applicaton/json")
                            .method(original.method(), original.body());
                    Request request = requestBuilder.build();

                    return chain.proceed(request);


                }

            });

        }


        Retrofit retrofit = builder.client(httpClient).build();
        return retrofit.create(serviceClass);

    }

}
