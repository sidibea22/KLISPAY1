package com.ntatech.klispay;

import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("id")
    int mId;

    @SerializedName("nom")
    String mName;

    public User(int id, String name ) {
        this.mId = id;
        this.mName = name;
    }
}
