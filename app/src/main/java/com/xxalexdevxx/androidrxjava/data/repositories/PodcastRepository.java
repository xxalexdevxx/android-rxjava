package com.xxalexdevxx.androidrxjava.data.repositories;

import android.util.Log;

import com.xxalexdevxx.androidrxjava.data.model.Podcast;
import com.xxalexdevxx.androidrxjava.data.remote.PodcastApiInterface;
//import com.xxalexdevxx.androidrxjava.data.remote.PodcastSearchResponse;
import com.xxalexdevxx.androidrxjava.data.remote.ApiServiceClient;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.schedulers.Schedulers;


import io.reactivex.rxjava3.disposables.Disposable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PodcastRepository {

    private List<Podcast> podcasts;

    public PodcastRepository() {
    }

    PodcastApiInterface podcastApiService = ApiServiceClient.getPodcastApiService();

    @NonNull Observable<Podcast> observable = podcastApiService.searchPodcasts("fish")
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread());

    public void getPodcasts() {
        observable.subscribe(new Observer<Podcast>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull Podcast podcast) {
                podcasts = new ArrayList<>();
                podcasts = podcast.getPodcasts();

                for (Podcast thePodcast : podcasts) {
                    Log.d("Response", "onNext: " + thePodcast.getPodcastTitle());
                }
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }}




//    public void testRetrofit() {
//        PodcastApiInterface podcastApiInterface;
//
//        podcastApiInterface = ApiServiceClient.getPodcastApiService();
//
//        Call<Podcast> call = podcastApiInterface.searchPodcasts("dog");
//
//        call.enqueue(new Callback<Podcast>() {
//            @Override
//            public void onResponse(Call<Podcast> call, Response<Podcast> response) {
//                Log.d("Response", "onResponse: " + response.code());
//
//                List<Podcast> podcasts = response.body().getPodcasts();
//
//                for (Podcast podcast : podcasts) {
//                    Log.d("response", "onResponse: " + podcast.getPodcastTitle());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<Podcast> call, Throwable t) {
//
//            }
//        });

