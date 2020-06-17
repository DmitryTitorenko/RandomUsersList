package com.example.randomusers.view.activity;


import com.example.randomusers.view.base.BaseView;

import javax.inject.Inject;

import moxy.InjectViewState;
import moxy.MvpPresenter;

@InjectViewState
public class MainPresenter extends MvpPresenter<BaseView> {

    @Inject
    MainPresenter() {
    }
}
