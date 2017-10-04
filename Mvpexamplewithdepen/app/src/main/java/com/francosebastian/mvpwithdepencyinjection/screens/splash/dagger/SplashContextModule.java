package com.francosebastian.mvpwithdepencyinjection.screens.splash.dagger;

import com.francosebastian.mvpwithdepencyinjection.screens.splash.SplashScreenActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by franco on 02-10-17.
 */

@Module
public class SplashContextModule {

    SplashScreenActivity splashContext;

    public SplashContextModule(SplashScreenActivity context) {
        this.splashContext = context;
    }

    @SplashScope
    @Provides
    SplashScreenActivity provideSplashContext() {
        return splashContext;
    }


}