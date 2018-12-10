package com.example.vlad.tankwiki.data.api;

import com.example.vlad.tankwiki.data.model.detail.DetailResponse;
import com.example.vlad.tankwiki.data.model.info.InfoResponse;
import com.example.vlad.tankwiki.data.model.tanks.TanksResponse;

import java.util.Map;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

interface ApiService {
    @GET("vehicles/")
    Single<TanksResponse> tanks(@Query("application_id") String appId, @QueryMap Map<String, String> options);
    @GET("vehicleprofile/")
    Single<DetailResponse> details(@Query("application_id") String appId, @Query("tank_id") Integer tankId);

    @GET("info/")
    Single<InfoResponse> info(@Query("application_id") String appId, @Query("fields") String fields);
}
