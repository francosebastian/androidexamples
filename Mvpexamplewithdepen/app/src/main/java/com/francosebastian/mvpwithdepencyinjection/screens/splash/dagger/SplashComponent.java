package com.francosebastian.mvpwithdepencyinjection.screens.splash.dagger;

import com.francosebastian.mvpwithdepencyinjection.application.builder.AppComponent;
import com.francosebastian.mvpwithdepencyinjection.screens.splash.SplashScreenActivity;

import dagger.Component;

/**
 * Created by franco on 02-10-17.
 */

@SplashScope
@Component(modules = {SplashContextModule.class, SplashModule.class}, dependencies = {AppComponent.class})
public interface SplashComponent {
    void inject(SplashScreenActivity activity);
}
