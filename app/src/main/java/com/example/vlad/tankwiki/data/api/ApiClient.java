package com.example.vlad.tankwiki.data.api;

import com.example.vlad.tankwiki.data.beans.TanksResponse;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Single;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static final String APP_ID = "06fc6671484ae67256ff47bfba5bb78e";
    private static final String BASE_URL = "https://api.worldoftanks.ru/wot/encyclopedia/";

    private static final int DEFAULT_LIMIT = 10;
    private static final int DEFAULT_PAGE_NO = 1;

    private static Retrofit mRetrofit;

    private static Retrofit buildRetrofit() {
        if (mRetrofit == null) {
            mRetrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return mRetrofit;
    }

    public static Single<TanksResponse> tanks(Map<String, String> options) {
        if (options != null) {
            options.put("limit", String.valueOf(DEFAULT_LIMIT));
            return buildRetrofit().create(ApiService.class).tanks(APP_ID, options);
        } else {
            Map<String, String> queryMap = new HashMap<>();
            queryMap.put("limit", String.valueOf(DEFAULT_LIMIT));
            queryMap.put("page_no", String.valueOf(DEFAULT_PAGE_NO));
            return buildRetrofit().create(ApiService.class).tanks(APP_ID, queryMap);
        }

    }

}
