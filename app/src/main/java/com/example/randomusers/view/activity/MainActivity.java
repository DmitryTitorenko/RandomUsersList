package com.example.randomusers.view.activity;

import android.os.Bundle;

import com.example.randomusers.R;
import com.example.randomusers.view.base.BaseActivity;

import org.jetbrains.annotations.Nullable;

import javax.inject.Inject;
import javax.inject.Provider;

import moxy.presenter.InjectPresenter;
import moxy.presenter.ProvidePresenter;

public class MainActivity extends BaseActivity implements IMainView {

    @InjectPresenter
    MainPresenter presenter;

    @Inject
    Provider<MainPresenter> presenterProvider;

    @ProvidePresenter
    MainPresenter providePresenter() {
        return presenterProvider.get();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
