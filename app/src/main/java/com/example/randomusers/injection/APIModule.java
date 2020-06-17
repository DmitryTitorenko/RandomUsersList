package com.example.randomusers.injection;

import com.example.randomusers.data.network.API;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class APIModule {

    @Provides
    @Singleton
    API buildRetrofitConfig() {
        OkHttpClient.Builder httpClient = getBaseHttpConfig();
        Retrofit.Builder retrofit = new Retrofit.Builder()
                .baseUrl(API.BASE_URL)
                .client(httpClient.build())
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create()))
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create());
        return retrofit.build().create(API.class);
    }

    private OkHttpClient.Builder getBaseHttpConfig() {
        HttpLoggingInterceptor log = new HttpLoggingInterceptor();
        log.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
        okHttpClient.addInterceptor(log);
        return okHttpClient;
    }
}
