package com.example.pivotal.androidbootcamp;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit.RestAdapter;

@Singleton
public class RetroServiceManager {

    private static String API_URL = "http://api.sportradar.us/nfl-t1/";

    @Inject
    public RetroServiceManager() {

    }

    public RetroInterface getService() {
        return new RestAdapter.Builder()
                .setEndpoint(API_URL)
                .build()
                .create(RetroInterface.class);
    }


}
