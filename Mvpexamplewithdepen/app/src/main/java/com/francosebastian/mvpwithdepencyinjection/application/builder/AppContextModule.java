package com.francosebastian.mvpwithdepencyinjection.application.builder;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by franco on 29-09-17.
 */

@Module
public class AppContextModule {

    private final Context context;

    public AppContextModule(Context aContext){
        this.context = aContext;
    }

    @AppScope
    @Provides
    Context provideAppContext(){
        return context;
    }
}
