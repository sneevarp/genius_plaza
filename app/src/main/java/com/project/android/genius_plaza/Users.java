package com.project.android.genius_plaza;

import com.google.gson.annotations.SerializedName;

public class Users {
        @SerializedName("first_name")
        private String firstname;
        @SerializedName("last_name")
        private String lastname;
        private String avatar;


    public Users(String firstname, String lastname, String avatar) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.avatar = avatar;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getAvatar() {
        return avatar;
    }
}
