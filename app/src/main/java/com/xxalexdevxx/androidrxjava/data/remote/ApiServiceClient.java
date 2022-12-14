package com.xxalexdevxx.androidrxjava.data.remote;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiServiceClient {

    private static OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new HeaderInterceptor())
            .build();

    private static Retrofit getRetrofitInstance() {
        return new Retrofit.Builder()
                .baseUrl(RequestConstants.BASE_URL)
                .client(client)
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    // this is how we access the retrofit api service from other places
    public static PodcastApiInterface getPodcastApiService() {
        return getRetrofitInstance().create(PodcastApiInterface.class);
    }

}
