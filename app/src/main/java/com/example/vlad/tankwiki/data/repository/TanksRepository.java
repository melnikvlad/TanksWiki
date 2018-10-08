package com.example.vlad.tankwiki.data.repository;

import com.example.vlad.tankwiki.data.api.ApiClient;
import com.example.vlad.tankwiki.data.beans.TanksResponse;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Single;

public class TanksRepository {
    public Single<TanksResponse> fetchTanks() {
        return ApiClient.tanks(null);
    }

    public Single<TanksResponse> fetchTanksWith(final Map<String, String> options) {
        return ApiClient.tanks(options);
    }
}
