package com.francosebastian.mvpwithdepencyinjection.screens.splash.core;

import com.francosebastian.mvpwithdepencyinjection.api.ProfileApi;
import com.francosebastian.mvpwithdepencyinjection.models.Profile;
import com.francosebastian.mvpwithdepencyinjection.screens.splash.SplashScreenActivity;
import com.francosebastian.mvpwithdepencyinjection.utils.NetworkUtils;

import rx.Observable;

/**
 * Created by franco on 02-10-17.
 */


public class SplashModel {


    private ProfileApi api;
    private SplashScreenActivity splashContext;

    public SplashModel(ProfileApi api, SplashScreenActivity splashCtx) {
        this.api = api;
        this.splashContext = splashCtx;

    }

    Observable<Profile> provideListHeroes() {
        return api.getProfiles();
    }

    Observable<Boolean> isNetworkAvailable() {
        return NetworkUtils.isNetworkAvailableObservable(splashContext);
    }


    public void gotoHeroesListActivity() {
         splashContext.showHeroesListActivity();

    }


}