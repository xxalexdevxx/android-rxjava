package com.xxalexdevxx.androidrxjava.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.xxalexdevxx.androidrxjava.R;
import com.xxalexdevxx.androidrxjava.model.Podcast;
import com.xxalexdevxx.androidrxjava.remote.PodcastApi;
import com.xxalexdevxx.androidrxjava.remote.PodcastSearchResponse;
import com.xxalexdevxx.androidrxjava.remote.ServiceGenerator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PodcastApi podcastApiService = ServiceGenerator.getPodcastApiService();

        Call<PodcastSearchResponse> responseCall = podcastApiService.searchPodcast("dog");

        responseCall.enqueue(new Callback<PodcastSearchResponse>() {
            @Override
            public void onResponse(Call<PodcastSearchResponse> call, Response<PodcastSearchResponse> response) {
                Log.d("Response", "onResponse: " + response.toString());
                if (response.code() == 200) {
                    Log.d("Response", "onResponse: " + response.body().toString());
                    List<Podcast> podcasts = new ArrayList<>(response.body().getPodcasts());

                    for(Podcast podcast: podcasts) {
                        Log.d("Response", "onResponse: " + podcast.getPodcastTitle());
                    }
                } else {
                    try {
                        Log.d("Response", "onResponse: " + response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<PodcastSearchResponse> call, Throwable t) {

            }
        });

    }
}