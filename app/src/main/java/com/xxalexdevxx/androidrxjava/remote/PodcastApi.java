package com.xxalexdevxx.androidrxjava.remote;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PodcastApi {
    // SEARCH ALL PODCASTS BY TERM
    // https://api.podcastindex.org/api/1.0/search/byterm?q=fitness);
    @GET("api/1.0/search/byterm")
    Call<PodcastSearchResponse> searchPodcast(
            //retrofit automatically adds a ? for the first query, then a & for all other queries below it
            @Query("q") String query
    );
}
