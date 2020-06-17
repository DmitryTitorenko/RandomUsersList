package com.example.randomusers.data.network;

import com.example.randomusers.model.ResponseUserList;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;

public interface API {
    String BASE_URL = "https://randomuser.me/api/";

    @GET("?results=20")
    Single<ResponseUserList> getUserList();
}
