package com.example.randomusers.view.user_description;

import com.example.randomusers.injection.Description;
import com.example.randomusers.view.base.BaseView;

import moxy.viewstate.strategy.alias.AddToEndSingle;

public interface IUserDescription extends BaseView {

    @AddToEndSingle
    void getDescription(Description description);
}
