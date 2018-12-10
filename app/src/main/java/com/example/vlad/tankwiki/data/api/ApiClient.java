package com.example.vlad.tankwiki.data.api;

import android.util.Log;

import com.example.vlad.tankwiki.data.model.detail.DetailResponse;
import com.example.vlad.tankwiki.data.model.info.InfoRequestFields;
import com.example.vlad.tankwiki.data.model.info.InfoResponse;
import com.example.vlad.tankwiki.data.model.tanks.TanksResponse;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Singleton;

import io.reactivex.Single;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static final String APP_ID = "06fc6671484ae67256ff47bfba5bb78e";
    private static final String BASE_URL = "https://api.worldoftanks.ru/wot/encyclopedia/";

    public static final int DEFAULT_LIMIT = 10;

    private static Retrofit _retrofit;

    private static Retrofit buildRetrofit() {
        if (_retrofit == null) {
            _retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return _retrofit;
    }

    public Single<TanksResponse> tanks(int page, Map<String, String> options) {
        if (options == null) {
            options = new HashMap<>();
        }
        options.put("limit", String.valueOf(DEFAULT_LIMIT));
        options.put("page_no", String.valueOf(page));
        return buildRetrofit().create(ApiService.class).tanks(APP_ID, options);
    }

    public Single<DetailResponse> profile(int tankId) {
        return buildRetrofit().create(ApiService.class).details(APP_ID, tankId);
    }

}
