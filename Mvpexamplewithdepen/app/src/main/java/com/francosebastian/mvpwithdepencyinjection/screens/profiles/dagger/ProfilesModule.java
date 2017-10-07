package com.francosebastian.mvpwithdepencyinjection.screens.profiles.dagger;

import com.francosebastian.mvpwithdepencyinjection.api.ProfileApi;
import com.francosebastian.mvpwithdepencyinjection.screens.profiles.ProfilesScreenActivity;
import com.francosebastian.mvpwithdepencyinjection.screens.profiles.core.ProfilesModel;
import com.francosebastian.mvpwithdepencyinjection.screens.profiles.core.ProfilesPresenter;
import com.francosebastian.mvpwithdepencyinjection.screens.profiles.core.ProfilesView;
import com.francosebastian.mvpwithdepencyinjection.utils.Rx.RxSchedulers;

import dagger.Module;
import dagger.Provides;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by franco on 06-10-17.
 */

@Module
public class ProfilesModule {

    ProfilesScreenActivity profilesScreenActivity;

    public ProfilesModule(ProfilesScreenActivity context)
    {
        this.profilesScreenActivity = context;
    }

    @ProfilesScope
    @Provides
    ProfilesView provideView(){
        return new ProfilesView(profilesScreenActivity);
    }

    @ProfilesScope
    @Provides
    ProfilesPresenter providePresenter(RxSchedulers schedulers, ProfilesView view, ProfilesModel model){
        CompositeSubscription susbscripcions = new CompositeSubscription();
        return new ProfilesPresenter(schedulers, model, view, susbscripcions);
    }

    @ProfilesScope
    @Provides
    ProfilesScreenActivity provideContext(){
        return profilesScreenActivity;
    }


    @ProfilesScope
    @Provides
    ProfilesModel provideModel(ProfileApi api){
        return new ProfilesModel(profilesScreenActivity, api);
    }


}
