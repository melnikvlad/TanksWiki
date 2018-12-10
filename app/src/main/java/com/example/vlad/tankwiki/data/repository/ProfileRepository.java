package com.example.vlad.tankwiki.data.repository;

import com.example.vlad.tankwiki.data.api.ApiClient;
import com.example.vlad.tankwiki.data.model.detail.DetailResponse;

import io.reactivex.Single;

public class ProfileRepository {
    private final ApiClient _api;

    public ProfileRepository(ApiClient apiClient) {
        _api = apiClient;
    }

    public Single<DetailResponse> execute(int tankId) {
        return _api.profile(tankId);
    }
}
