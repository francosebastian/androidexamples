package com.francosebastian.mvpwithdepencyinjection.screens.profiles;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.francosebastian.mvpwithdepencyinjection.application.AppController;
import com.francosebastian.mvpwithdepencyinjection.models.Profile;
import com.francosebastian.mvpwithdepencyinjection.screens.profiles.core.ProfilesPresenter;
import com.francosebastian.mvpwithdepencyinjection.screens.profiles.core.ProfilesView;
import com.francosebastian.mvpwithdepencyinjection.screens.profiles.dagger.DaggerProfilesComponent;
import com.francosebastian.mvpwithdepencyinjection.screens.profiles.dagger.ProfilesModule;

import javax.inject.Inject;

/**
 * Created by franco on 04-10-17.
 */

public class ProfilesScreenActivity extends AppCompatActivity{

    @Inject
    ProfilesView view;

    @Inject
    ProfilesPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerProfilesComponent.builder().appComponent(AppController.getNetComponent()).profilesModule(new ProfilesModule(this)).build().inject(this);
        setContentView(view.view());
        presenter.onCreate();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    public void goToProfileDetailsActivity(Profile profile) {

    }
}
