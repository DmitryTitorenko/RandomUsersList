package com.example.randomusers.view.base;

import android.content.Context;

import androidx.annotation.NonNull;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasAndroidInjector;
import dagger.android.support.AndroidSupportInjection;
import moxy.MvpAppCompatFragment;

public abstract class BaseFragment extends MvpAppCompatFragment implements BaseView, HasAndroidInjector {

    @Inject
    DispatchingAndroidInjector<Object> androidInjector;

    @Override
    public AndroidInjector<Object> androidInjector() {
        return androidInjector;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    @Override
    public void showMessage(String message) {
        BaseActivity activity = (BaseActivity) getActivity();
        assert activity != null;
        activity.showMessage(message);
    }
}