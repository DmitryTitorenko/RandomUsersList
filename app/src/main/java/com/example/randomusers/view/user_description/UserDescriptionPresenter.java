package com.example.randomusers.view.user_description;


import com.example.randomusers.injection.Description;

import javax.inject.Inject;

import moxy.InjectViewState;
import moxy.MvpPresenter;

@InjectViewState
public class UserDescriptionPresenter extends MvpPresenter<IUserDescription> {

    @Inject
    UserDescriptionPresenter() {
    }

    @Inject
    Description description;

    @Override
    protected void onFirstViewAttach() {
        getViewState().getDescription(description);
        super.onFirstViewAttach();
    }
}
