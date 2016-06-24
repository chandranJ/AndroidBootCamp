package com.example.pivotal.androidbootcamp;


import dagger.Module;

@Module(
        injects = {
                MainActivity.class,
                SportsDetailActivity.class
        },
        complete = false
)
public class AppInjectModule {
    public AppInjectModule() {
    }


}


