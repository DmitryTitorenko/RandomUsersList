package com.example.randomusers;

import com.example.randomusers.injection.DaggerAppComponent;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

public class App extends DaggerApplication {

    @Override
    protected AndroidInjector<DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().application(this).build();
    }
}
