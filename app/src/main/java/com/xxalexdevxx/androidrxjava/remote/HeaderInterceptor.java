package com.xxalexdevxx.androidrxjava.remote;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class HeaderInterceptor implements Interceptor {

    @NotNull
    @Override
    public Response intercept(@NotNull Chain chain) throws IOException {

        Auth auth = new Auth();

        Request request = chain.request()
                .newBuilder()
                .addHeader("User-Agent", RequestConstants.USER_AGENT)
                .addHeader("X-Auth-Key", RequestConstants.API_KEY)
                .addHeader("X-Auth-Date", Auth.getHeaderTime(auth))
                .addHeader("Authorization", Auth.getAuthHash(auth))
                .build();
        return chain.proceed(request);
    }
}