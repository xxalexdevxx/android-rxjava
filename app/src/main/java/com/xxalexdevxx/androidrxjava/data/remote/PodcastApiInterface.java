package com.xxalexdevxx.androidrxjava.data.remote;

import com.xxalexdevxx.androidrxjava.data.model.Podcast;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PodcastApiInterface {

    // SEARCH ALL PODCASTS BY TERM
    // https://api.podcastindex.org/api/1.0/search/byterm?q=fitness);
    @GET("api/1.0/search/byterm")
    Observable<Podcast> searchPodcasts(
            //retrofit automatically adds a ? for the first query, then a & for all other queries below it
            @Query("q") String query
    );


    // SEARCH ALL PODCASTS BY TERM
    // https://api.podcastindex.org/api/1.0/search/byterm?q=fitness);
//    @GET("api/1.0/search/byterm")
//    Call<Podcast> searchPodcasts(
//            //retrofit automatically adds a ? for the first query, then a & for all other queries below it
//            @Query("q") String query
//    );


    // SEARCH ALL PODCASTS BY TERM
    // https://api.podcastindex.org/api/1.0/search/byterm?q=fitness);
//    @GET("api/1.0/search/byterm")
//    Observable<List<Podcast>> searchPodcasts(
//            //retrofit automatically adds a ? for the first query, then a & for all other queries below it
//            @Query("q") String query
//    );








}
