package com.ntatech.klispay.model;

import com.google.gson.annotations.SerializedName;

public class Partner {
    @SerializedName("_email")
    public String email;
    @SerializedName("_password")
    public String password;


    public Partner(String email, String password) {
        this.email = email;
        this.password = password;
    }


}
