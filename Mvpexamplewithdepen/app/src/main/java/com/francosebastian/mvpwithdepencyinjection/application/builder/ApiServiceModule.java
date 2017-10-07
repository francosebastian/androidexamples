package com.francosebastian.mvpwithdepencyinjection.application.builder;

import com.francosebastian.mvpwithdepencyinjection.api.ProfileApi;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by franco on 29-09-17.
 */

@Module
public class ApiServiceModule {

    private static final String BASE_URL = "http://10.0.2.2:3000/";
    @AppScope
    @Provides
    ProfileApi provideApiService(OkHttpClient client, GsonConverterFactory gson, RxJavaCallAdapterFactory rxAdapter)
    {
        Retrofit retrofit = new Retrofit.Builder().client(client)
                .baseUrl(BASE_URL).addConverterFactory(gson).
                addCallAdapterFactory(rxAdapter).build();
        return retrofit.create(ProfileApi.class);
    }
}
