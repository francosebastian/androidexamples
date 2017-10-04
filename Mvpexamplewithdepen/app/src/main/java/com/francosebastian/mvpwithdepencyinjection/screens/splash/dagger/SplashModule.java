package com.francosebastian.mvpwithdepencyinjection.screens.splash.dagger;

import com.francosebastian.mvpwithdepencyinjection.api.ProfileApi;
import com.francosebastian.mvpwithdepencyinjection.screens.splash.SplashScreenActivity;
import com.francosebastian.mvpwithdepencyinjection.screens.splash.core.SplashModel;
import com.francosebastian.mvpwithdepencyinjection.screens.splash.core.SplashPresenter;
import com.francosebastian.mvpwithdepencyinjection.screens.splash.core.SplashView;
import com.francosebastian.mvpwithdepencyinjection.utils.Rx.RxSchedulers;

import dagger.Module;
import dagger.Provides;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by franco on 02-10-17.
 */


@Module
public class SplashModule {


    @SplashScope
    @Provides
    SplashPresenter providePresenter(RxSchedulers schedulers, SplashModel model) {
        CompositeSubscription compositeSubscription = new CompositeSubscription();
        return new SplashPresenter(model, schedulers, compositeSubscription);
    }


    @SplashScope
    @Provides
    SplashView provideSplashView(SplashScreenActivity context) {
        return new SplashView(context);
    }


    @SplashScope
    @Provides
    SplashModel provideSplashModel(ProfileApi api, SplashScreenActivity ctx) {
        return new SplashModel(api, ctx);
    }

}