package com.example.randomusers.view.base;

import moxy.MvpView;
import moxy.viewstate.strategy.alias.AddToEndSingle;

public interface BaseView extends MvpView {

    @AddToEndSingle
    void showMessage(String message);
}
