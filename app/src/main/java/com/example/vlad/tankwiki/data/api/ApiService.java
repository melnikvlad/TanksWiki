package com.example.vlad.tankwiki.data.api;

import com.example.vlad.tankwiki.data.beans.TanksResponse;

import java.util.Map;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

interface ApiService {
    @GET("vehicles/")
    Single<TanksResponse> tanks(@Query("application_id") String app_id, @QueryMap Map<String, String> options);
}
