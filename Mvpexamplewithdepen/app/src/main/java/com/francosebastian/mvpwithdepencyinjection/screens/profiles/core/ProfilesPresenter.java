package com.francosebastian.mvpwithdepencyinjection.screens.profiles.core;

import android.util.Log;

import com.francosebastian.mvpwithdepencyinjection.models.Profile;
import com.francosebastian.mvpwithdepencyinjection.utils.Rx.RxSchedulers;
import com.francosebastian.mvpwithdepencyinjection.utils.UiUtils;

import java.util.ArrayList;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by franco on 04-10-17.
 */

public class ProfilesPresenter {
    ProfilesView view;
    ProfilesModel model;
    RxSchedulers rxSchedulers;
    CompositeSubscription subscriptions;
    ArrayList<Profile> profiles = new ArrayList<>();

    public ProfilesPresenter(RxSchedulers schedulers, ProfilesModel model, ProfilesView view, CompositeSubscription sub) {
        this.rxSchedulers = schedulers;
        this.view = view;
        this.model = model;
        this.subscriptions = sub;
    }

    public void onCreate() {

        Log.d("enter to presenter", "oki");
        subscriptions.add(getHeroesList());
        subscriptions.add(respondToClick());
    }

    public void onDestroy() {
        subscriptions.clear();
    }


    private Subscription respondToClick() {

        return view.itemClicks().subscribe(integer -> model.goToProfileDetailsActivity(profiles.get(integer)));
    }


    private Subscription getHeroesList() {

        return model.isNetworkAvailable().doOnNext(networkAvailable -> {
            if (!networkAvailable) {
                Log.d("no conn", "no connexion");
                // UiUtils.showSnackbar();
                // Show Snackbar can't use app
            }
        }).
                filter(isNetworkAvailable -> true).
                flatMap(isAvailable -> model.provideListProfiles()).
                subscribeOn(rxSchedulers.internet()).
                observeOn(rxSchedulers.androidThread()).subscribe(heroes -> {
                    Log.d("ok loaded", "cccc");
                    //view.swapAdapter((ArrayList<Profile>) profiles.getElements());
                    //profiles = (ArrayList<Profile>) profiles.getElements();
                }, throwable -> {
                    UiUtils.handleThrowable(throwable);
                }
        );

    }
}
