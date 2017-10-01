package com.francosebastian.mvpwithdepencyinjection.models;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

/**
 * Created by franco on 29-09-17.
 */

public class Profile implements Serializable {
    @Expose
    private String firstname;
    @Expose
    private String lastname;
    @Expose
    private String email;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
