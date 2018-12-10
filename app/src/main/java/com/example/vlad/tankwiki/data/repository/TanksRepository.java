package com.example.vlad.tankwiki.data.repository;

import com.example.vlad.tankwiki.data.api.ApiClient;
import com.example.vlad.tankwiki.data.api.FieldsMapper;
import com.example.vlad.tankwiki.data.model.filter.IFilterItem;
import com.example.vlad.tankwiki.data.model.tanks.TanksResponse;

import java.util.Map;
import java.util.Set;

import javax.inject.Inject;

import io.reactivex.Single;

public class TanksRepository {
    private ApiClient _apiClient;

    @Inject
    public TanksRepository(ApiClient apiClient) {
        _apiClient = apiClient;
    }

    public Single<TanksResponse> fetchTanksWith(final int page, final Map<String, Set<IFilterItem>> options) {
        Map<String, String> params = FieldsMapper.generateMap(options);
        return _apiClient.tanks(page, params);
    }
}
