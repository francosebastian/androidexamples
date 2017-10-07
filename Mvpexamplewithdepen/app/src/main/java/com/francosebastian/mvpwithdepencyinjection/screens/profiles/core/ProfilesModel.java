package com.francosebastian.mvpwithdepencyinjection.screens.profiles.core;

import com.francosebastian.mvpwithdepencyinjection.api.ProfileApi;
import com.francosebastian.mvpwithdepencyinjection.models.Profile;
import com.francosebastian.mvpwithdepencyinjection.screens.profiles.ProfilesScreenActivity;
import com.francosebastian.mvpwithdepencyinjection.utils.NetworkUtils;

import rx.Observable;

/**
 * Created by franco on 04-10-17.
 */

public class ProfilesModel {

    ProfilesScreenActivity context;
    ProfileApi api;

    public ProfilesModel(ProfilesScreenActivity context, ProfileApi api){
        this.api = api;
        this.context = context;
    }

    Observable<Profile> provideListProfiles(){
        return api.getProfiles();
    }

    Observable<Boolean> isNetworkAvailable(){
        return NetworkUtils.isNetworkAvailableObservable(context);
    }

    public void goToProfileDetailsActivity(Profile profile){
        context.goToProfileDetailsActivity(profile);
    }
}
