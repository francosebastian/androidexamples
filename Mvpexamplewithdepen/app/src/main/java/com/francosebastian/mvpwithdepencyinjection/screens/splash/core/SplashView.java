package com.francosebastian.mvpwithdepencyinjection.screens.splash.core;

/**
 * Created by franco on 02-10-17.
 */

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.francosebastian.mvpwithdepencyinjection.R;
import com.francosebastian.mvpwithdepencyinjection.screens.splash.SplashScreenActivity;

import butterknife.ButterKnife;


public class SplashView {

    private View view;

    public SplashView(SplashScreenActivity context) {
        FrameLayout parent = new FrameLayout(context);
        parent.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        view = LayoutInflater.from(context).inflate(R.layout.activity_splash, parent, true);
        ButterKnife.bind(view, context);
    }

    public View constructView() {
        return view;
    }


}
