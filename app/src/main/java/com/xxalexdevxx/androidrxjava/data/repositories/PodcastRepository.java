package com.xxalexdevxx.androidrxjava.data.repositories;

import android.util.Log;

import com.xxalexdevxx.androidrxjava.data.model.Podcast;
import com.xxalexdevxx.androidrxjava.data.remote.PodcastApiInterface;
import com.xxalexdevxx.androidrxjava.data.remote.PodcastSearchResponse;
import com.xxalexdevxx.androidrxjava.data.remote.ApiServiceClient;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.schedulers.Schedulers;


import io.reactivex.rxjava3.disposables.Disposable;

public class PodcastRepository {

    private List<Podcast> podcasts;

    public PodcastRepository() {
    }

    PodcastApiInterface podcastApiService = ApiServiceClient.getPodcastApiService();

    Observable<PodcastSearchResponse> observable = podcastApiService.searchPodcasts("dog")
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread());

    public Observable<PodcastSearchResponse> getPodcasts() {
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

        return observable;
    }
}
