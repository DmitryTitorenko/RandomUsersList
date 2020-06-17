package com.example.randomusers.view.users;

import com.example.randomusers.model.ResponseUserList;
import com.example.randomusers.view.base.BaseView;

import moxy.viewstate.strategy.alias.AddToEndSingle;

public interface IUsersView extends BaseView {

    @AddToEndSingle
    void getUsers(ResponseUserList list);
}
