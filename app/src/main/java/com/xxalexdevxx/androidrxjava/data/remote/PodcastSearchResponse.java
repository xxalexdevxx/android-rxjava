package com.xxalexdevxx.androidrxjava.data.remote;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.xxalexdevxx.androidrxjava.data.model.Podcast;

import java.util.List;

// search for a podcast by term
//https://api.podcastindex.org/api/1.0/search/bytitle?q=the+art+of+manliness
public class PodcastSearchResponse {

    private List<Podcast> feeds;

    // add getter and setter for the feeds field
    public List<Podcast> getFeeds() {
        return feeds;
    }

    public void setFeeds(List<Podcast> feeds) {
        this.feeds = feeds;
    }

//
//    @SerializedName("count") // number of podcasts found from search by term
//    @Expose()
//    private int count;
//
//    @SerializedName("feeds")
//    @Expose()
//    private List<Podcast> podcasts;
//
//    public int getCount() {
//        return count;
//    }
//
//    public List<Podcast> getPodcasts() {
//        return podcasts;
//    }
//
//    @Override
//    public String toString() {
//        return "PodcastSearchResponse{" +
//                "count=" + count +
//                ", podcasts=" + podcasts +
//                '}';
//    }
}
