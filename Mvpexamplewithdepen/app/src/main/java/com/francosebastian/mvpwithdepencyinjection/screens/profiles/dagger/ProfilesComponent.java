package com.francosebastian.mvpwithdepencyinjection.screens.profiles.dagger;

import com.francosebastian.mvpwithdepencyinjection.application.builder.AppComponent;
import com.francosebastian.mvpwithdepencyinjection.screens.profiles.ProfilesScreenActivity;

import dagger.Component;

/**
 * Created by franco on 06-10-17.
 */

@ProfilesScope
@Component(dependencies = {AppComponent.class} , modules = {ProfilesModule.class})
public interface ProfilesComponent {
    void inject (ProfilesScreenActivity profileActivity);
}