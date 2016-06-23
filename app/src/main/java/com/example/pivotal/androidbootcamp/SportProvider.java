package com.example.pivotal.androidbootcamp;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class SportProvider {

    private RetroInterface mApi;

    @Inject
    public SportProvider() {

    }

    public void getSportDetail() {
        return;
        //mApi.getSportDetail(...);
    }
}
