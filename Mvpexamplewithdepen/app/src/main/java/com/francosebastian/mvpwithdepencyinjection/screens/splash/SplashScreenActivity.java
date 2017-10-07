package com.francosebastian.mvpwithdepencyinjection.screens.splash;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.francosebastian.mvpwithdepencyinjection.application.AppController;
import com.francosebastian.mvpwithdepencyinjection.screens.profiles.ProfilesScreenActivity;
import com.francosebastian.mvpwithdepencyinjection.screens.splash.core.SplashPresenter;
import com.francosebastian.mvpwithdepencyinjection.screens.splash.core.SplashView;
import com.francosebastian.mvpwithdepencyinjection.screens.splash.dagger.DaggerSplashComponent;
import com.francosebastian.mvpwithdepencyinjection.screens.splash.dagger.SplashContextModule;

import javax.inject.Inject;

/**
 * Created by franco on 02-10-17.
 */


public class SplashScreenActivity extends AppCompatActivity {


    @Inject
    SplashView view;
    @Inject
    SplashPresenter splashPresenter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DaggerSplashComponent.builder().
                appComponent(AppController.getNetComponent()).
                splashContextModule(new SplashContextModule(this)).
                build().inject(this);

        setContentView(view.constructView());
        splashPresenter.onCreate();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        splashPresenter.onDestroy();
    }

    public void showHeroesListActivity() {
        Log.d("loaded", "ok showed");
        Intent i = new Intent(this, ProfilesScreenActivity.class);
        startActivity(i);
    }

}