package com.example.vlad.tankwiki.domain.use_cases;

import com.example.vlad.tankwiki.data.beans.Tank;
import com.example.vlad.tankwiki.data.beans.TanksResponse;

import java.util.List;
import java.util.Map;

import io.reactivex.Single;

public interface LoadDataUseCase {

    Single<List<Tank>> executeDefault();

    Single<TanksResponse> execute(Map<String, String> params);
}
