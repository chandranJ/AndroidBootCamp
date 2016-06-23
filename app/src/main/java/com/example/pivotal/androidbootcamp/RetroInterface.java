package com.example.pivotal.androidbootcamp;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

public interface RetroInterface {

    @GET("/2015/REG/1/MIN/SF/pbp.json?api_key=j374hhgzj3w9c64u672n5vmg")
    void getSportDetail(Callback<RetroPojo> sport);

    @GET("/{details}?api_key=j374hhgzj3w9c64u672n5vmg")
    void getSportsSummaryDetail(@Path(value = "details", encode = false) String details, Callback<DetailsModel> summary);
}
