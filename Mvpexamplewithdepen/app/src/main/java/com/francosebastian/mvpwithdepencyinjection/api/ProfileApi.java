package com.francosebastian.mvpwithdepencyinjection.api;

import com.francosebastian.mvpwithdepencyinjection.models.Profile;
import com.francosebastian.mvpwithdepencyinjection.models.Profiles;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by franco on 29-09-17.
 */

public interface ProfileApi {
    @GET("profiles")
    Observable<Profiles> getProfiles();
}

