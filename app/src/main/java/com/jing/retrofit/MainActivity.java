package com.jing.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.IOException;
import java.util.List;

import retrofit.Call;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GithubClient client = ServiceGenerator.createService(GithubClient.class);


        Call<List<Contributor>> call = client.contributors("jingdq", "retrofit_study");

        try {
            List<Contributor> contributors = call.execute().body();

            for (Contributor contributor : contributors) {
                System.out.println(
                        contributor.login + " (" + contributor.contributions + ")");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
