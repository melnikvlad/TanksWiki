package com.example.vlad.tankwiki.domain.interactors;

import com.example.vlad.tankwiki.data.beans.Tank;
import com.example.vlad.tankwiki.data.beans.TanksResponse;
import com.example.vlad.tankwiki.data.repository.TanksRepository;
import com.example.vlad.tankwiki.domain.use_cases.LoadDataUseCase;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.reactivex.Single;

public class LoadDataInteractor implements LoadDataUseCase {
    private final TanksRepository _tanksRepository;

    public LoadDataInteractor() {
        this._tanksRepository = new TanksRepository();
    }

    @Override
    public Single<List<Tank>> executeDefault() {
        return _tanksRepository.fetchTanks()
                .map(this::tankResponseMapper);
    }

    @Override
    public Single<TanksResponse> execute(Map<String, String> params) {
        return _tanksRepository.fetchTanksWith(params);
    }

    private List<Tank> tankResponseMapper(final TanksResponse response) {
        Map<String, Tank> map = response.getData();
        List<Tank> tankList = new ArrayList<>();
        for (String key : map.keySet()) {
            tankList.add(map.get(key));
        }
        return tankList;
    }
}
