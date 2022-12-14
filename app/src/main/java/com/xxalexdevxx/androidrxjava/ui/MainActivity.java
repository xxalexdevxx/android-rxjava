package com.xxalexdevxx.androidrxjava.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.fragment.DialogFragmentNavigatorDestinationBuilder;

import android.os.Bundle;
import android.util.Log;

import com.xxalexdevxx.androidrxjava.R;
import com.xxalexdevxx.androidrxjava.data.model.Podcast;
import com.xxalexdevxx.androidrxjava.data.remote.ApiServiceClient;
import com.xxalexdevxx.androidrxjava.data.remote.PodcastApiInterface;
import com.xxalexdevxx.androidrxjava.data.repositories.PodcastRepository;

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

        PodcastRepository podcastRepository = new PodcastRepository();
//        podcastRepository.testRetrofit();

        podcastRepository.getPodcasts();

    }
}