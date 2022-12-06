package com.xxalexdevxx.androidrxjava.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Podcast {
    //  https://api.podcastindex.org/api/1.0/podcasts/byfeedid?id=
    // temp note: variable names differ from the api variable names
    @SerializedName("id")
    @Expose
    private String podcastId; // Podcast Index given id

    @SerializedName("url")
    @Expose
    private String podcastUrl; // current feed url

    @SerializedName("podcastGuid")
    @Expose
    private String podcastGuid; // A unique global identifier associated with the podcast itself

    @SerializedName("title")
    @Expose
    private String podcastTitle; //podcast title

    @SerializedName("description")
    @Expose
    private String podcastDescription; // podcast description

    @SerializedName("image")
    @Expose
    private String podcastImage; // image url

    @SerializedName("author")
    @Expose
    private String podcastAuthor; // author, not ownerName

    private int lastUpdateTime; // Unix epoch time
    private int episodeCount; // available only from podcast id search query

    public Podcast(String podcastId, String podcastUrl, String podcastGuid, String podcastTitle, String podcastDescription, String podcastImage, String podcastAuthor, int lastUpdateTime, int episodeCount) {
        this.podcastId = podcastId;
        this.podcastUrl = podcastUrl;
        this.podcastGuid = podcastGuid;
        this.podcastTitle = podcastTitle;
        this.podcastDescription = podcastDescription;
        this.podcastImage = podcastImage;
        this.podcastAuthor = podcastAuthor;
        this.lastUpdateTime = lastUpdateTime;
        this.episodeCount = episodeCount;
    }

    public Podcast() {
    }

    public String getPodcastId() {
        return podcastId;
    }

    public void setPodcastId(String podcastId) {
        this.podcastId = podcastId;
    }

    public String getPodcastUrl() {
        return podcastUrl;
    }

    public void setPodcastUrl(String podcastUrl) {
        this.podcastUrl = podcastUrl;
    }

    public String getPodcastGuid() {
        return podcastGuid;
    }

    public void setPodcastGuid(String podcastGuid) {
        this.podcastGuid = podcastGuid;
    }

    public String getPodcastTitle() {
        return podcastTitle;
    }

    public void setPodcastTitle(String podcastTitle) {
        this.podcastTitle = podcastTitle;
    }

    public String getPodcastDescription() {
        return podcastDescription;
    }

    public void setPodcastDescription(String podcastDescription) {
        this.podcastDescription = podcastDescription;
    }

    public String getPodcastImage() {
        return podcastImage;
    }

    public void setPodcastImage(String podcastImage) {
        this.podcastImage = podcastImage;
    }

    public String getPodcastAuthor() {
        return podcastAuthor;
    }

    public void setPodcastAuthor(String podcastAuthor) {
        this.podcastAuthor = podcastAuthor;
    }

    public int getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(int lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public int getEpisodeCount() {
        return episodeCount;
    }

    public void setEpisodeCount(int episodeCount) {
        this.episodeCount = episodeCount;
    }

    @Override
    public String toString() {
        return "Podcast{" +
                "podcastId='" + podcastId + '\'' +
                ", podcastUrl='" + podcastUrl + '\'' +
                ", podcastGuid='" + podcastGuid + '\'' +
                ", podcastTitle='" + podcastTitle + '\'' +
                ", podcastDescription='" + podcastDescription + '\'' +
                ", podcastImage='" + podcastImage + '\'' +
                ", podcastAuthor='" + podcastAuthor + '\'' +
                ", lastUpdateTime=" + lastUpdateTime +
                ", episodeCount=" + episodeCount +
                '}';
    }
}
