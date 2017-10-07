package com.francosebastian.mvpwithdepencyinjection.screens.profiles.core;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.francosebastian.mvpwithdepencyinjection.R;
import com.francosebastian.mvpwithdepencyinjection.models.Profile;
import com.francosebastian.mvpwithdepencyinjection.screens.profiles.ProfilesScreenActivity;
import com.francosebastian.mvpwithdepencyinjection.screens.profiles.list.ProfilesAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observable;

/**
 * Created by franco on 04-10-17.
 */

public class ProfilesView {
    @BindView(R.id.activity_profiles_list_recycleview)
    RecyclerView list;

    View view;

    ProfilesAdapter adapter;

    public ProfilesView(ProfilesScreenActivity context ) {
        FrameLayout parent = new FrameLayout(context);
        parent.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        view = LayoutInflater.from(context).inflate(R.layout.activity_profiles_list, parent, true);
        ButterKnife.bind(this, view);

        adapter = new ProfilesAdapter();

        list.setAdapter(adapter);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(context);
        list.setLayoutManager(mLayoutManager);


    }

    public Observable<Integer> itemClicks()
    {
        return adapter.observeClicks();
    }

    public View view() {
        return view;
    }

    public void swapAdapter(ArrayList<Profile> profiles)
    {
        adapter.swapAdapter(profiles);
    }
}
