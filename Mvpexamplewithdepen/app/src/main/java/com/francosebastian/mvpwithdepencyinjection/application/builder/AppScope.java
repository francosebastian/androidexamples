package com.francosebastian.mvpwithdepencyinjection.application.builder;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by franco on 29-09-17.
 */

@Scope
@Retention(RetentionPolicy.CLASS)
@interface AppScope {
}
