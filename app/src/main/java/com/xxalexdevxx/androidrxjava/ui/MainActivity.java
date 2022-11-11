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

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private List<Podcast> podcasts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PodcastApi podcastApiService = ServiceGenerator.getPodcastApiService();

        Observable<PodcastSearchResponse> observable = podcastApiService.searchPodcasts("reading")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());

        observable.subscribe(new Observer<PodcastSearchResponse>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull PodcastSearchResponse podcastSearchResponse) {
                podcasts = new ArrayList<>();
                List<Podcast> podcasts = podcastSearchResponse.getPodcasts();

                for (Podcast podcast: podcasts) {
                    Log.d("Response", "onNext: " + podcast.getPodcastTitle());

                }
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

    }
}