package com.francosebastian.mvpwithdepencyinjection.application.builder;

import com.francosebastian.mvpwithdepencyinjection.utils.Rx.AppRxSchedulers;
import com.francosebastian.mvpwithdepencyinjection.utils.Rx.RxSchedulers;

import dagger.Module;
import dagger.Provides;

/**
 * Created by franco on 29-09-17.
 */

@Module
public class RxModule {

    @Provides
    RxSchedulers provideRxSchedulers() {
        return new AppRxSchedulers();
    }
}