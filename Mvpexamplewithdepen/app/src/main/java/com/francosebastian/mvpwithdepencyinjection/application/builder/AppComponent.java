package com.francosebastian.mvpwithdepencyinjection.application.builder;

import com.francosebastian.mvpwithdepencyinjection.api.ProfileApi;
import com.francosebastian.mvpwithdepencyinjection.utils.Rx.RxSchedulers;

import dagger.Component;

/**
 * Created by franco on 29-09-17.
 */

    /**
     * Created by ygharsallah on 30/03/2017.
     */
    @AppScope
    @Component(modules = {NetworkModule.class, AppContextModule.class, RxModule.class, ApiServiceModule.class})
    public interface AppComponent {

        RxSchedulers rxSchedulers();
        ProfileApi apiService();


    }
