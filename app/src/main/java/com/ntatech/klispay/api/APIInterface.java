package com.ntatech.klispay.api;

import com.ntatech.klispay.model.Partner;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface APIInterface {

    @POST("/login_check")
    Call<Partner> getToken(@Body Partner partner);
}
