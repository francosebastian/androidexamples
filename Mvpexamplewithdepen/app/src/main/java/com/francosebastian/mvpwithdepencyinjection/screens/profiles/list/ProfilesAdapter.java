package com.francosebastian.mvpwithdepencyinjection.screens.profiles.list;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.francosebastian.mvpwithdepencyinjection.R;
import com.francosebastian.mvpwithdepencyinjection.models.Profile;

import java.util.ArrayList;

import rx.Observable;
import rx.subjects.PublishSubject;

/**
 * Created by franco on 06-10-17.
 */

public class ProfilesAdapter extends RecyclerView.Adapter<ProfilesViewHolder> {

    private final PublishSubject<Integer> itemClicks = PublishSubject.create();
    ArrayList<Profile> listProfiles = new ArrayList<>();


    public void swapAdapter(ArrayList<Profile> profiles)
    {
        this.listProfiles.clear();
        this.listProfiles.addAll(profiles);
        notifyDataSetChanged();
    }

    public Observable<Integer> observeClicks() {
        return itemClicks;
    }


    @Override
    public ProfilesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_profile, parent, false);
        return new ProfilesViewHolder(view ,itemClicks);
    }

    @Override
    public void onBindViewHolder(ProfilesViewHolder holder, int position) {

        Profile profile = listProfiles.get(position);
        holder.bind(profile);

    }


    @Override
    public int getItemCount() {
        if (listProfiles != null && listProfiles.size() > 0) {
            return listProfiles.size();
        } else {
            return 0;
        }
    }
}