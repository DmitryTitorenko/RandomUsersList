package com.example.randomusers.data.repository;

import com.example.randomusers.data.network.API;
import com.example.randomusers.model.ResponseUserList;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.rxjava3.core.Single;

@Singleton
public class Repo {
    private final API api;

    @Inject
    Repo(API api) {
        this.api = api;
    }

    public Single<ResponseUserList> getUserList() {
        return api.getUserList();
    }
}
