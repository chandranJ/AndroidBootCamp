package com.example.pivotal.androidbootcamp;

import retrofit.RestAdapter;

public class RetroServiceManager {

    private static String API_URL = "http://api.sportradar.us/nfl-t1/";

    public RetroServiceManager() {

    }

    public RetroInterface getService() {
        return new RestAdapter.Builder()
                .setEndpoint(API_URL)
                .build()
                .create(RetroInterface.class);
    }


}
