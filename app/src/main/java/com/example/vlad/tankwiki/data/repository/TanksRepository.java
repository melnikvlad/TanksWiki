package com.example.vlad.tankwiki.data.repository;

import com.example.vlad.tankwiki.data.api.ApiClient;
import com.example.vlad.tankwiki.data.model.TanksResponse;

import java.util.Map;

import javax.inject.Inject;

import io.reactivex.Single;

public class TanksRepository {
    private ApiClient _apiClient;

    @Inject
    public TanksRepository(ApiClient apiClient) {
        _apiClient = apiClient;
    }

    public Single<TanksResponse> fetchTanks() {
        return _apiClient.tanks(null);
    }

    public Single<TanksResponse> fetchTanksWith(final Map<String, String> options) {
        return _apiClient.tanks(options);
    }
}
