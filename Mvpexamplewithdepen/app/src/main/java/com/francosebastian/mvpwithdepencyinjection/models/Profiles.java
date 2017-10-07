package com.francosebastian.mvpwithdepencyinjection.models;

import com.google.gson.annotations.Expose;

import java.util.List;

/**
 * Created by franco on 06-10-17.
 */

public class Profiles {
    @Expose
    private List<Profile> elements;

    public List<Profile> getElements() {
        return elements;
    }

    public void setElements(List<Profile> elements) {
        this.elements = elements;
    }
}
