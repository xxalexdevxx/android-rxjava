package com.xxalexdevxx.androidrxjava.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.xxalexdevxx.androidrxjava.R;
import com.xxalexdevxx.androidrxjava.data.model.Podcast;
import com.xxalexdevxx.androidrxjava.data.repositories.PodcastRepository;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Podcast> podcasts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PodcastRepository podcastRepository = new PodcastRepository();
        
        podcastRepository.getPodcasts();

    }
}