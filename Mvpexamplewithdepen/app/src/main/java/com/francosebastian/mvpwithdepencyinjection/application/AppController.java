package com.francosebastian.mvpwithdepencyinjection.application;

/**
 * Created by franco on 29-09-17.
 */

import android.app.Application;

import com.francosebastian.mvpwithdepencyinjection.BuildConfig;
import com.francosebastian.mvpwithdepencyinjection.application.builder.AppComponent;
import com.francosebastian.mvpwithdepencyinjection.application.builder.AppContextModule;
import com.francosebastian.mvpwithdepencyinjection.application.builder.DaggerAppComponent;
import com.squareup.leakcanary.LeakCanary;

import timber.log.Timber;

/**
 * Created by ygharsallah on 30/03/2017.
 */


public class AppController extends Application {


    private static AppComponent appComponent;


    @Override
    public void onCreate() {
        super.onCreate();
        initialiseLogger();
        initAppComponent();

        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);

    }

    private void initAppComponent() {
        appComponent = DaggerAppComponent.builder().appContextModule(new AppContextModule(this)).build();
    }


    private void initialiseLogger() {
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        } else {
            Timber.plant(new Timber.Tree() {
                @Override
                protected void log(int priority, String tag, String message, Throwable t) {
                    //TODO  decide what to log in release version
                }
            });
        }
    }

    public static AppComponent getNetComponent() {
        return appComponent;
    }
}
