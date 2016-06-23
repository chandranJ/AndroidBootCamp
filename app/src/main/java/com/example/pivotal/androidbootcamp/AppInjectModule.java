package com.example.pivotal.androidbootcamp;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(
        injects = {
                MainActivity.class,
                SportsDetailActivity.class
        },
        library = true,
        complete = false
)
public class AppInjectModule {
    public AppInjectModule() {
    }

    @Provides
    @Singleton
    RetroServiceManager getService()
    {
        return new RetroServiceManager();
    }
}


