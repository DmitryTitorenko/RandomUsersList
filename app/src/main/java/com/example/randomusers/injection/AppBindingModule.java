package com.example.randomusers.injection;

import com.example.randomusers.view.activity.MainActivity;
import com.example.randomusers.view.user_description.UserDescriptionFragment;
import com.example.randomusers.view.users.UsersFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class AppBindingModule {

    @ContributesAndroidInjector
    abstract MainActivity bindMainActivity();

    @ContributesAndroidInjector
    abstract UsersFragment bindImagesFragment();

    @ContributesAndroidInjector
    abstract UserDescriptionFragment bindUserDescriptionFragment();
}
