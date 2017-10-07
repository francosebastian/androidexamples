package com.francosebastian.mvpwithdepencyinjection.screens.profiles.list;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.francosebastian.mvpwithdepencyinjection.R;
import com.francosebastian.mvpwithdepencyinjection.models.Profile;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.subjects.PublishSubject;

/**
 * Created by franco on 06-10-17.
 */

public class ProfilesViewHolder extends RecyclerView.ViewHolder {

    View view;

    //@BindView(R.id.item_profile_image)
    //ImageView imageProfile;
    @BindView(R.id.item_profile_firstname)
    TextView firstNameProfile;
    @BindView(R.id.item_profile_lastname)
    TextView dateReleaseHero;
    @BindView(R.id.item_profile_text)
    TextView descriptionHero;

    public ProfilesViewHolder(View itemView, PublishSubject<Integer> clickSubject) {
        super(itemView);
        this.view = itemView;
        ButterKnife.bind(this, view);
        view.setOnClickListener(v -> clickSubject.onNext(getAdapterPosition())
        );
    }

    void bind(Profile profile) {
        //Glide.with(view.getContext()).load(hero.getImage()).into(imageHero);

        firstNameProfile.setText(TextUtils.isEmpty(profile.getFirstname()) ? "Sin nombre" : profile.getFirstname());
        firstNameProfile.setText(TextUtils.isEmpty(profile.getLastname()) ? "Sin apellido" : profile.getLastname());
        firstNameProfile.setText(TextUtils.isEmpty(profile.getEmail()) ? "Sin nombre" : profile.getEmail());

        //separatorHero.setBackgroundColor(Color.parseColor(hero.getColor()));
    }

}